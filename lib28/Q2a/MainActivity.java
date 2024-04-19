package com.example.slips;

import android.content.Intent;
import android.os.Bundle;

import android.widget.EditText;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the references to the EditTexts and the Button
        EditText personNameEditText = findViewById(R.id.personNameEditText);
        EditText greetMessageEditText = findViewById(R.id.greetMessageEditText);
        Button nextActivityButton;
        nextActivityButton = findViewById(R.id.nextActivityButton);

        // Set a click listener on the Button
        nextActivityButton.setOnClickListener(v -> {
            // Get the strings entered by the user
            String personName = personNameEditText.getText().toString();
            String greetMessage = greetMessageEditText.getText().toString();

            // Create an Intent to start the second activity
            Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);
            // Add the strings as extras to the Intent
            intent.putExtra("personName", personName);
            intent.putExtra("greetMessage", greetMessage);

            // Start the second activity
            startActivity(intent);
        });
    }
}