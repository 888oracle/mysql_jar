package com.example.slips;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String COLUMN_GNO = "gno";
    public static final String COLUMN_GNAME = "gname";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_NO_OF_PLAYERS = "no_of_players";
    private static final String DATABASE_NAME = "game.db";
    private static final String TABLE_NAME = "Game";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_GNO + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_GNAME + " TEXT NOT NULL, " + COLUMN_TYPE + " TEXT NOT NULL, " + COLUMN_NO_OF_PLAYERS + " INTEGER NOT NULL)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean updateNoOfPlayers(String game, int noOfPlayers) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NO_OF_PLAYERS, noOfPlayers);
        return db.update(TABLE_NAME, contentValues, COLUMN_TYPE + "=?", new String[]{game}) > 0;
    }

    public Cursor getAllRecords() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
}