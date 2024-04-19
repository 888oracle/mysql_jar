// Update your AndroidManifest.xml file to include permissions and the service declaration:

// <uses-permission android:name="android.permission.INTERNET" />
// <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />

// <application
//     ...
//     <service
//         android:name=".DownloadService"
//         android:exported="false" />
// </application>
package com.example.slips;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_URL = "https://en.wikipedia.org/wiki/Flower#/media/File:Flower_poster_2.jpg";

    private Button btnDownload;
    private TextView tvStatus;

    private BroadcastReceiver downloadReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String filePath = intent.getStringExtra(DownloadService.EXTRA_FILE_PATH);
            tvStatus.setText("Status: Download Complete\nFile saved at: " + filePath);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDownload = findViewById(R.id.btnDownload);
        tvStatus = findViewById(R.id.tvStatus);

        btnDownload.setOnClickListener(view -> {
            Intent downloadIntent = new Intent(MainActivity.this, DownloadService.class);
            downloadIntent.putExtra("file_url", FILE_URL);
            startService(downloadIntent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(downloadReceiver, new IntentFilter(DownloadService.ACTION_DOWNLOAD_COMPLETE));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(downloadReceiver);
    }
}