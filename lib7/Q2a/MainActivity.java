// Note that you will need to add the ResultActivity to your AndroidManifest.xml file:

// xml
// Edit
// Full Screen
// Copy code
// <activity android:name=".ResultActivity" />
package com.example.slips;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        calculate = findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1Value = Double.parseDouble(num1.getText().toString());
                double num2Value = Double.parseDouble(num2.getText().toString());

                double average = (num1Value + num2Value) / 2;
                double power = Math.pow(num1Value, num2Value);

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("average", average);
                intent.putExtra("power", power);
                startActivity(intent);
            }
        });
    }
}