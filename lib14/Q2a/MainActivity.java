// First, make sure you have the necessary permissions in your AndroidManifest.xml file 
// before application tag :
//
// <uses-permission android:name="android.permission.INTERNET" />
// <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
// <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />




package com.example.slips;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_ATTACHMENT = 123;
    private File attachmentFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnSendEmail).setOnClickListener(view -> {
            // Open file chooser to select an attachment
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("*/*");
            startActivityForResult(intent, REQUEST_CODE_ATTACHMENT);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ATTACHMENT && resultCode == RESULT_OK && data != null) {
            Uri selectedFileUri = data.getData();
            if (selectedFileUri != null) {
                attachmentFile = new File(getRealPathFromURI(selectedFileUri));
                if (attachmentFile.exists()) {
                    // Send email with attachment
                    sendEmailWithAttachment();
                } else {
                    Toast.makeText(this, "File not found", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void sendEmailWithAttachment() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"recipient@example.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject of the email");
        intent.putExtra(Intent.EXTRA_TEXT, "Body of the email");

        Uri attachmentUri = Uri.fromFile(attachmentFile);
        intent.putExtra(Intent.EXTRA_STREAM, attachmentUri);

        startActivity(Intent.createChooser(intent, "Send Email"));
    }

    private String getRealPathFromURI(Uri contentUri) {
        String filePath;
        String[] projection = {MediaStore.Images.Media.DATA};
        try (Cursor cursor = getContentResolver().query(contentUri, projection, null, null, null)) {
            if (cursor != null && ((Cursor) cursor).moveToFirst()) {
                int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                filePath = cursor.getString(columnIndex);
            } else {
                filePath = contentUri.getPath();
            }
        }
        return filePath;
    }
}
