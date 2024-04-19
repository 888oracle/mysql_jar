import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;
    private TextView displayTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);
        displayTextView = findViewById(R.id.displayTextView);

        // Update no_of_players for Badminton
        updateNumberOfPlayers("Badminton", 4);

        // Display all records
        displayAllRecords();
    }

    private void updateNumberOfPlayers(String gameName, int newNumberOfPlayers) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("UPDATE Game SET no_of_players = ? WHERE name = ?", new String[]{String.valueOf(newNumberOfPlayers), gameName});
        db.close();
    }

    private void displayAllRecords() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Game", null);

        StringBuilder stringBuilder = new StringBuilder();
        while (cursor.moveToNext()) {
            int no = cursor.getInt(cursor.getColumnIndex("no"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String type = cursor.getString(cursor.getColumnIndex("type"));
            int noOfPlayers = cursor.getInt(cursor.getColumnIndex("no_of_players"));

            stringBuilder.append("No: ").append(no)
                    .append(", Name: ").append(name)
                    .append(", Type: ").append(type)
                    .append(", No of Players: ").append(noOfPlayers)
                    .append("\n");
        }
        cursor.close();
        db.close();

        displayTextView.setText(stringBuilder.toString());
    }
}
