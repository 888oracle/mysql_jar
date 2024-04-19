package com.example.slips;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<Version> versions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        versions.add(new Version("Android 1.0", "1.0"));
        versions.add(new Version("Android 1.1", "1.1"));
        versions.add(new Version("Android 1.5", "1.5"));
        versions.add(new Version("Android 1.6", "1.6"));
        versions.add(new Version("Android 2.0", "2.0"));
        versions.add(new Version("Android 2.1", "2.1"));
        // Add more versions...

        listView = findViewById(R.id.listView);
        VersionAdapter versionAdapter = new VersionAdapter(this, versions);
        listView.setAdapter(versionAdapter);
    }
}