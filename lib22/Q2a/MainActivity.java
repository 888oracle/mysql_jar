package com.example.slips;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // If you want to display the greeting message in the TextView directly
        TextView greetingTextView = findViewById(R.id.greetingTextView);
        greetingTextView.setText("Hello, Welcome to this application");
    }
}
