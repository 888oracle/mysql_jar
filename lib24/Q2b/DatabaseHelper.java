package com.example.slips;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "company_database";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_COMPANY_TABLE = "CREATE TABLE " + CompanyContract.CompanyEntry.TABLE_NAME + " ("
                + CompanyContract.CompanyEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CompanyContract.CompanyEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + CompanyContract.CompanyEntry.COLUMN_ADDRESS + " TEXT NOT NULL, "
                + CompanyContract.CompanyEntry.COLUMN_PHONE + " INTEGER NOT NULL"
                + ");";

        db.execSQL(SQL_CREATE_COMPANY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_DELETE_COMPANY_TABLE = "DROP TABLE IF EXISTS " + CompanyContract.CompanyEntry.TABLE_NAME;
        db.execSQL(SQL_DELETE_COMPANY_TABLE);
        onCreate(db);
    }

}