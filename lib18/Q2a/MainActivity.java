package com.example.slips;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText ed1, ed2;
    Button btn_val;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        btn_val = findViewById(R.id.btn_val);
        tv = findViewById(R.id.tv);

        btn_val.setOnClickListener(view -> {
            try {
                int a = Integer.parseInt(ed1.getText().toString());
                int b = Integer.parseInt(ed2.getText().toString());

                if (a > 10 || b > 10) {
                    tv.setText("Rejected as numbers should be less than or equal to 10");
                } else {
                    tv.setText("Num 1 : " + a + "\nNum 2 : " + b);
                }
            } catch (NumberFormatException e) {
                tv.setText("Please enter valid numbers.");
            }
        });
    }
}
