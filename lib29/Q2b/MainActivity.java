package com.example.slips;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText numberEditText;
    Button calculateButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberEditText = findViewById(R.id.numberEditText);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = numberEditText.getText().toString().trim();
                if (!TextUtils.isEmpty(input)) {
                    int number = Integer.parseInt(input);
                    String result = calculatePalindromeAndReverse(number);
                    resultTextView.setText(result);
                } else {
                    resultTextView.setText("Please enter a number");
                }
            }
        });
    }

    private String calculatePalindromeAndReverse(int number) {
        StringBuilder result = new StringBuilder();
        // Check palindrome
        if (isPalindrome(number)) {
            result.append(number).append(" is a palindrome.\n");
        } else {
            result.append(number).append(" is not a palindrome.\n");
        }
        // Calculate reverse
        int reversedNumber = reverseNumber(number);
        result.append("Reverse of ").append(number).append(": ").append(reversedNumber);
        return result.toString();
    }

    private boolean isPalindrome(int number) {
        int originalNumber = number;
        int reversedNumber = reverseNumber(number);
        return originalNumber == reversedNumber;
    }

    private int reverseNumber(int number) {
        int reversedNumber = 0;
        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }
        return reversedNumber;
    }
}