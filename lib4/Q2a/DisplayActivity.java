package com.example.slips;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        TableLayout tableLayout = findViewById(R.id.tableLayout);
        String[] labels = {"Name", "Surname", "Class", "Gender", "Hobbies", "Marks"};

        for (String label : labels) {
            TableRow row = new TableRow(this);
            TextView labelTextView = new TextView(this);
            labelTextView.setText(label);
            labelTextView.setPadding(16, 8, 16, 8);
            row.addView(labelTextView);

            TextView valueTextView = new TextView(this);
            valueTextView.setText(getIntent().getStringExtra(label.toLowerCase()));
            valueTextView.setPadding(16, 8, 16, 8);
            row.addView(valueTextView);

            tableLayout.addView(row);
        }
    }
}
