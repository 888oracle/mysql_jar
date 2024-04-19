package com.example.slips;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class DBManager {
    private static final DatabaseHelper dbHelper = new DatabaseHelper(null);

    public DBManager() {
    }

    public void insertCustomer(String name, String address, String phno) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.NAME, name);
        contentValues.put(DatabaseHelper.ADDRESS, address);
        contentValues.put(DatabaseHelper.PHNO, phno);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
        database.close();
    }

    public void showAllCustomers() {
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        String[] columns = {DatabaseHelper.ID, DatabaseHelper.NAME, DatabaseHelper.ADDRESS, DatabaseHelper.PHNO};
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        String customerDetails = "";
        while (cursor.moveToNext()) {
            @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.ID));
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.NAME));
            @SuppressLint("Range") String address = cursor.getString(cursor.getColumnIndex(DatabaseHelper.ADDRESS));
            @SuppressLint("Range") String phno = cursor.getString(cursor.getColumnIndex(DatabaseHelper.PHNO));
            customerDetails = "Customer ID: " + id + ",\nName: " + name + ",\nAddress: " + address + ",\nPhone Number: " + phno + ",\n\n";
        }
        Toast.makeText(null, customerDetails, Toast.LENGTH_LONG).show();
        cursor.close();
        database.close();
    }
}