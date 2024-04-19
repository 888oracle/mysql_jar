package com.example.slips;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView notificationMessageTextView = findViewById(R.id.notificationMessageTextView);
        String notificationMessage = getIntent().getStringExtra("notificationMessage");
        notificationMessageTextView.setText(notificationMessage);
    }
}
