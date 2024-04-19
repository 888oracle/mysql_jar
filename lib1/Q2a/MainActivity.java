package com.example.slips;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to start SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                // Pass the message as an extra with the intent
                intent.putExtra("message", "Hello");
                startActivity(intent);
            }
        });
    }
}
