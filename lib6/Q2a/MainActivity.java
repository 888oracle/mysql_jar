package com.example.slips;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText firstNumberEditText, secondNumberEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumberEditText = findViewById(R.id.firstNumberEditText);
        secondNumberEditText = findViewById(R.id.secondNumberEditText);
        resultTextView = findViewById(R.id.resultTextView);
    }

    public void performAddition(View view) {
        try {
            double firstNumber = Double.parseDouble(firstNumberEditText.getText().toString());
            double secondNumber = Double.parseDouble(secondNumberEditText.getText().toString());
            double result = firstNumber + secondNumber;
            resultTextView.setText("Result: " + result);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
        }
    }

    public void performSubtraction(View view) {
        try {
            double firstNumber = Double.parseDouble(firstNumberEditText.getText().toString());
            double secondNumber = Double.parseDouble(secondNumberEditText.getText().toString());
            double result = firstNumber - secondNumber;
            resultTextView.setText("Result: " + result);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
        }
    }

    public void performMultiplication(View view) {
        try {
            double firstNumber = Double.parseDouble(firstNumberEditText.getText().toString());
            double secondNumber = Double.parseDouble(secondNumberEditText.getText().toString());
            double result = firstNumber * secondNumber;
            resultTextView.setText("Result: " + result);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
        }
    }

    public void performDivision(View view) {
        try {
            double firstNumber = Double.parseDouble(firstNumberEditText.getText().toString());
            double secondNumber = Double.parseDouble(secondNumberEditText.getText().toString());
            if (secondNumber != 0) {
                double result = firstNumber / secondNumber;
                resultTextView.setText("Result: " + result);
            } else {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
        }
    }
}
