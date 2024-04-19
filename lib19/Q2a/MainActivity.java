package com.example.slips;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText ed1, ed2, ed3;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);
        btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(view -> {
            String val1 = ed1.getText().toString().trim();
            String val2 = ed2.getText().toString().trim();

            if (TextUtils.isEmpty(val1) || TextUtils.isEmpty(val2)) {
                ed3.setText("One or both of the inputs are empty.");
                return;
            }

            // Parse input strings into arrays
            String[] array1 = val1.split(",");
            String[] array2 = val2.split(",");

            // Convert arrays to lists
            List<String> list1 = new ArrayList<>(Arrays.asList(array1));
            List<String> list2 = new ArrayList<>(Arrays.asList(array2));

            // Merge lists
            List<String> mergedList = mergeLists(list1, list2);

            // Display merged result
            ed3.setText(TextUtils.join(", ", mergedList));
        });
    }

    private List<String> mergeLists(List<String> list1, List<String> list2) {
        List<String> mergedList = new ArrayList<>(list1);
        mergedList.addAll(list2);
        return mergedList;
    }
}
