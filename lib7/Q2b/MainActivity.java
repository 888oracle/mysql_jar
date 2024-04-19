//add DBManager and DatabaseHelper in manifest
package com.example.slips;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private DBManager dbManager = new DBManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Insert customer details
        dbManager.insertCustomer("John Doe", "Street 1, City 1, State 1", "1234567890");

        // Show all customer details
        dbManager.showAllCustomers();
    }
}