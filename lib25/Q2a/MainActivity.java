package com.example.slips;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private TextView textViewRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBar);
        textViewRating = findViewById(R.id.textViewRating);

        // Set a listener to RatingBar to update the TextView and show a Toast
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                // Update the TextView with the selected rating
                textViewRating.setText("Rating: " + rating);

                // Show a Toast with the number of stars selected
                Toast.makeText(MainActivity.this, "You rated: " + rating + " stars", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
