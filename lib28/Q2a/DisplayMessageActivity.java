package com.example.slips;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the references to the TextView
        TextView greetMessageTextView = findViewById(R.id.greetMessageTextView);

        // Get the strings from the Intent extras
        String personName = getIntent().getStringExtra("personName");
        String greetMessage = getIntent().getStringExtra("greetMessage");

        // Display the strings in the TextView
        greetMessageTextView.setText(String.format("%s: %s", personName, greetMessage));
    }
}