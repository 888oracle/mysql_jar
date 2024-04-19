package com.example.slips;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DBManager dbManager;
    private ListView listView;
    private TextView nameView;
    private TextView addressView;
    private TextView phoneView;
    private Button insertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        nameView = findViewById(R.id.nameView);
        addressView = findViewById(R.id.addressView);
        phoneView = findViewById(R.id.phoneView);
        insertButton = findViewById(R.id.insertButton);

        dbManager = new DBManager(this);
        dbManager.open();

        insertButton.setOnClickListener(v -> {
            dbManager.insert("Company Name", "Company Address", "123456789");
            List<String> companies = dbManager.getAllCompanies();
            ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
                    android.R.layout.simple_list_item_1, companies);
            listView.setAdapter(adapter);
            clearViews();
        });

        List<String> companies = dbManager.getAllCompanies();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, companies);
        listView.setAdapter(adapter);
        clearViews();

        dbManager.close();
    }

    private void clearViews() {
        nameView.setText("");
        addressView.setText("");
        phoneView.setText("");
    }
}