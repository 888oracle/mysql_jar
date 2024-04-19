package com.example.slips;


import android.os.Bundle;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int[] flags = {android.R.drawable.ic_dialog_alert, android.R.drawable.ic_dialog_info, android.R.drawable.ic_menu_camera, android.R.drawable.ic_menu_gallery};
    String[] countryNames = {"India", "USA", "China", "Japan", "UK"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.simpleSpinner);
        CustomAdapter customAdapter = new CustomAdapter(this, flags, countryNames);
        spinner.setAdapter(customAdapter);
    }
}