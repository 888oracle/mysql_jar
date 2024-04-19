// Declare the service in AndroidManifest.xml:
// Open AndroidManifest.xml and declare the MediaPlayerService as a service.

// Copy code
// <service android:name=".MediaPlayerService" />



package com.example.slips;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button startButton;
    private Button stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAudioService();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAudioService();
            }
        });
    }

    private void startAudioService() {
        Intent serviceIntent = new Intent(this, MediaPlayerService.class);
        startService(serviceIntent);
    }

    private void stopAudioService() {
        Intent serviceIntent = new Intent(this, MediaPlayerService.class);
        stopService(serviceIntent);
    }
}
