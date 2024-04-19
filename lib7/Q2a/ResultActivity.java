package com.example.slips;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView averageTextView, powerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        averageTextView = findViewById(R.id.average);
        powerTextView = findViewById(R.id.power);

        Intent intent = getIntent();
        double average = intent.getDoubleExtra("average", 0);
        double power = intent.getDoubleExtra("power", 0);

        averageTextView.setText("Average: " + average);
        powerTextView.setText("Power: "+ power);
    }
}