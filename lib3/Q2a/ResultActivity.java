package com.example.slips;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView factorialTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        factorialTextView = findViewById(R.id.factorialTextView);

        long factorial = getIntent().getLongExtra("factorial", 0);
        factorialTextView.setText("Factorial value: " + factorial);
    }
}
