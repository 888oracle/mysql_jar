package com.example.slips;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText numberEditText;
    private Button submitButton;
    private TextView errorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberEditText = findViewById(R.id.numberEditText);
        submitButton = findViewById(R.id.submitButton);
        errorTextView = findViewById(R.id.errorTextView);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numberStr = numberEditText.getText().toString().trim();
                if (!numberStr.isEmpty()) {
                    int number = Integer.parseInt(numberStr);
                    if (number > 0) {
                        long factorial = calculateFactorial(number);
                        openResultActivity(factorial);
                        errorTextView.setVisibility(View.GONE); // Hide error message if shown
                    } else {
                        errorTextView.setVisibility(View.VISIBLE);
                        errorTextView.setText("Please enter a positive number.");
                    }
                } else {
                    errorTextView.setVisibility(View.VISIBLE);
                    errorTextView.setText("Please enter a number.");
                }
            }
        });
    }

    private long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    private void openResultActivity(long factorial) {
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("factorial", factorial);
        startActivity(intent);
    }
}
