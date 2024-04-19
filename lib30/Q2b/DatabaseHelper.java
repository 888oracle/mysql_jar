package com.example.slips;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "EmployeeManager.db";
    private static final String TABLE_EMPLOYEE = "Employee";

    private static final String COLUMN_ENO = "Eno";
    private static final String COLUMN_ENAME = "Ename";
    private static final String COLUMN_DESIGNATION = "Designation";
    private static final String COLUMN_SALARY = "Salary";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_EMPLOYEE_TABLE = "CREATE TABLE " + TABLE_EMPLOYEE +
                "(" +
                COLUMN_ENO + " INTEGER PRIMARY KEY," +
                COLUMN_ENAME + " TEXT," +
                COLUMN_DESIGNATION + " TEXT," +
                COLUMN_SALARY + " REAL" +
                ")";
        db.execSQL(CREATE_EMPLOYEE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE);
        onCreate(db);
    }

    public void addEmployee(Employee employee) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ENO, employee.getEno());
        values.put(COLUMN_ENAME, employee.getEname());
        values.put(COLUMN_DESIGNATION, employee.getDesignation());
        values.put(COLUMN_SALARY, employee.getSalary());
        db.insert(TABLE_EMPLOYEE, null, values);
        db.close();
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_EMPLOYEE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Employee employee = new Employee();
                employee.setEno(cursor.getInt(0));
                employee.setEname(cursor.getString(1));
                employee.setDesignation(cursor.getString(2));
                employee.setSalary(cursor.getDouble(3));
                employeeList.add(employee);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return employeeList;
    }
}

