package com.example.slips;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText num1, num2;
    TextView result;
    double final_sum, final_difference, final_product, final_quotient;
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);
    }

    public void doOperation(View v) {
        String s11 = num1.getText().toString();
        String s22 = num2.getText().toString();
        operation = v.getTag().toString();

        if (s11.isEmpty() || s22.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Enter Numbers", Toast.LENGTH_SHORT).show();
        } else {
            double a = Double.parseDouble(s11);
            double b = Double.parseDouble(s22);

            switch (operation) {
                case "addition":
                    final_sum = a + b;
                    result.setText(String.valueOf(final_sum));
                    break;
                case "subtraction":
                    final_difference = a - b;
                    result.setText(String.valueOf(final_difference));
                    break;
                case "multiplication":
                    final_product = a * b;
                    result.setText(String.valueOf(final_product));
                    break;
                case "division":
                    if (b == 0) {
                        Toast.makeText(getApplicationContext(), "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    } else {
                        final_quotient = a / b;
                        result.setText(String.valueOf(final_quotient));
                    }
                    break;
                default:
                    Toast.makeText(getApplicationContext(), "Invalid Operation", Toast.LENGTH_SHORT).show();
            }
        }
    }
}