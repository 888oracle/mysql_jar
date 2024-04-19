//add DatabaseHelper file in manifest



package com.example.slips;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);

        // Update no_of_players to four where game is Badminton
        databaseHelper.updateNoOfPlayers("Badminton", 4);

        // Display all the records
        Cursor cursor = databaseHelper.getAllRecords();
        StringBuilder records = new StringBuilder();
        while (cursor.moveToNext()) {
            @SuppressLint("Range") int gno = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_GNO));
            @SuppressLint("Range") String gname = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_GNAME));
            @SuppressLint("Range") String type = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_TYPE));
            @SuppressLint("Range") int noOfPlayers = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_NO_OF_PLAYERS));
            records.append("GNO: ").append(gno).append(", GNAME: ").append(gname).append(", TYPE: ").append(type).append(", NO_OF_PLAYERS: ").append(noOfPlayers).append("\n");
        }
        ((TextView) findViewById(R.id.textView)).setText(records.toString());
    }
}