package com.example.slips;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String MOVIE_DETAILS = "movie_details";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // onClickListener for the button to move to the next activity
        findViewById(R.id.next_activity_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the movie details from the EditTexts
                String name = ((EditText) findViewById(R.id.name_edit_text)).getText().toString();
                int releaseYear = Integer.parseInt(((EditText) findViewById(R.id.year_edit_text)).getText().toString());
                double collection = Double.parseDouble(((EditText) findViewById(R.id.collection_edit_text)).getText().toString());

                // create a bundle to pass the movie details
                Bundle movieDetails = new Bundle();
                movieDetails.putString("name", name);
                movieDetails.putInt("year", releaseYear);
                movieDetails.putDouble("collection", collection);

                // start the next activity and pass the bundle with the movie details
                Intent nextActivity = new Intent(MainActivity.this, NextActivity.class);
                nextActivity.putExtras(movieDetails);
                startActivity(nextActivity);
            }
        });
    }
}