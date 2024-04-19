package com.example.slips;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        // get the movie details from the Intent
        Bundle movieDetails = getIntent().getExtras();
        String name = movieDetails.getString("name");
        int releaseYear = movieDetails.getInt("year");
        double collection = movieDetails.getDouble("collection");

        // display the movie details in the TextViews
        ((TextView) findViewById(R.id.name_text_view)).setText(name);
        ((TextView) findViewById(R.id.year_text_view)).setText(Integer.toString(releaseYear));
        ((TextView) findViewById(R.id.collection_text_view)).setText(Double.toString(collection));
    }
}