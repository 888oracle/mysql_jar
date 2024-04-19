package com.example.slips;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText numberEditText;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberEditText = findViewById(R.id.numberEditText);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateFactorial();
            }
        });
    }

    private void calculateFactorial() {
        String numberStr = numberEditText.getText().toString();
        if (numberStr.isEmpty()) {
            showAlert("Error", "Please enter a number.");
            return;
        }

        int number = Integer.parseInt(numberStr);
        int factorial = 1;

        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }

        showAlert("Factorial Result", "Factorial of " + number + " is " + factorial);
    }

    private void showAlert(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show();
    }
}
