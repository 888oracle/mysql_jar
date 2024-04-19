package com.example.slips;

import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadService extends IntentService {

    public static final String ACTION_DOWNLOAD_COMPLETE = "com.example.downloadservice.DOWNLOAD_COMPLETE";
    public static final String EXTRA_FILE_PATH = "file_path";

    public DownloadService() {
        super("DownloadService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String fileUrl = intent.getStringExtra("file_url");
            downloadFile(fileUrl);
        }
    }

    private void downloadFile(String fileUrl) {
        try {
            URL url = new URL(fileUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            // Create a directory for the downloaded file
            File directory = new File(Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DOWNLOADS) + "/MyDownloads");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Create a file to save the downloaded file
            File file = new File(directory, "downloaded_file.jpg");
            FileOutputStream outputStream = new FileOutputStream(file);

            InputStream inputStream = connection.getInputStream();

            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }

            outputStream.close();
            inputStream.close();

            sendBroadcast(file.getAbsolutePath());
        } catch (Exception e) {
            Log.e("DownloadService", "Error downloading file: " + e.getMessage());
        }
    }

    private void sendBroadcast(String filePath) {
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(ACTION_DOWNLOAD_COMPLETE);
        broadcastIntent.putExtra(EXTRA_FILE_PATH, filePath);
        sendBroadcast(broadcastIntent);
    }
}