//add this file in manifest
package com.example.slips;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView messageTextView = findViewById(R.id.messageTextView);

        // Get the intent that started this activity
        Intent intent = getIntent();
        // Get the message from the intent's extras
        String message = intent.getStringExtra("message");

        // Display the message in the TextView
        messageTextView.setText(message);
    }
}
