//add this file to manifest
package com.example.slips;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getIntent();
        TextView tvResult=findViewById(R.id.tvResult);
        //Toast.makeText(SecondActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
        tvResult.setText("Login Successful");
    }
}