package com.example.slips;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    TextView textview1;
    TimePicker timepicker;
    Button changetime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview1 = findViewById(R.id.textView1);
        timepicker = findViewById(R.id.timePicker);
        changetime = findViewById(R.id.button1);

        textview1.setText(getCurrentTime());

        changetime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview1.setText(getCurrentTime());
            }
        });
    }

    public String getCurrentTime() {
        int hour = timepicker.getHour();
        int minute = timepicker.getMinute();
        String currentTime = "Current Time: " + hour + ":" + minute;
        return currentTime;
    }
}
