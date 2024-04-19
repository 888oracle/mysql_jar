package com.example.slips;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper helper;

    public DBManager(Context context) {
        this.context = context;
    }

    public DBManager open() {
        helper = new DatabaseHelper(context);
        database = helper.getWritableDatabase();
        return this;
    }

    public void close() {
        helper.close();
    }

    public void insert(String name, String address, String phone) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CompanyContract.CompanyEntry.COLUMN_NAME, name);
        contentValues.put(CompanyContract.CompanyEntry.COLUMN_ADDRESS, address);
        contentValues.put(CompanyContract.CompanyEntry.COLUMN_PHONE, phone);
        database.insert(CompanyContract.CompanyEntry.TABLE_NAME, null, contentValues);
    }

    public List<String> getAllCompanies() {
        List<String> companies = new ArrayList<>();
        Cursor cursor = database.query(CompanyContract.CompanyEntry.TABLE_NAME,
                new String[]{CompanyContract.CompanyEntry.COLUMN_NAME, CompanyContract.CompanyEntry.COLUMN_ADDRESS,
                        CompanyContract.CompanyEntry.COLUMN_PHONE},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(0);
            String address = cursor.getString(1);
            String phone = cursor.getString(2);
            companies.add(String.format("Name: %s\nAddress: %s\nPhone: %s\n", name, address, phone));
        }
        return companies;
    }
}