//Add this file name in manifest in place of MainActivity

package com.example.slips;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class DisplayActivity extends AppCompatActivity {

    TextView displayTextView;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        db = new DatabaseHelper(this);

        displayTextView = findViewById(R.id.displayTextView);
        displayAllEmployees();
    }

    private void displayAllEmployees() {
        List<Employee> employees = db.getAllEmployees();
        StringBuilder sb = new StringBuilder();
        for (Employee emp : employees) {
            sb.append("Eno: ").append(emp.getEno()).append("\n");
            sb.append("Name: ").append(emp.getEname()).append("\n");
            sb.append("Designation: ").append(emp.getDesignation()).append("\n");
            sb.append("Salary: ").append(emp.getSalary()).append("\n\n");
        }
        displayTextView.setText(sb.toString());
    }
}

