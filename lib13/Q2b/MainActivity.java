package com.example.slips;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etPhone;
    private Button btnAdd, btnDelete;
    private ListView listView;
    private ArrayList<String> studentList;
    private ArrayAdapter<String> adapter;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        listView = findViewById(R.id.listView);

        studentList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentList);
        listView.setAdapter(adapter);

        refreshStudentList();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();

                if (!name.isEmpty() && !phone.isEmpty()) {
                    dbHelper.addStudent(name, phone);
                    refreshStudentList();
                    etName.getText().clear();
                    etPhone.getText().clear();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter name and phone number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();

                if (!name.isEmpty()) {
                    dbHelper.deleteStudent(name);
                    refreshStudentList();
                    etName.getText().clear();
                    etPhone.getText().clear();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter name to delete", Toast.LENGTH_SHORT).show();
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Selected: " + item, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void refreshStudentList() {
        studentList.clear();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Student", null);

        if (cursor.moveToFirst()) {
            do {
                int sid = cursor.getInt(cursor.getColumnIndex("Sid"));
                String name = cursor.getString(cursor.getColumnIndex("Sname"));
                String phone = cursor.getString(cursor.getColumnIndex("phno"));
                studentList.add(sid + ": " + name + " - " + phone);
            } while (cursor.moveToNext());
        }

        cursor.close();
        adapter.notifyDataSetChanged();
    }
}
