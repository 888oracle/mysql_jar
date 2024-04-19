package com.example.slips;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView displayTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        displayTextView = findViewById(R.id.displayTextView);

        Intent intent = getIntent();
        if (intent != null) {
            String firstName = intent.getStringExtra("FIRST_NAME");
            String middleName = intent.getStringExtra("MIDDLE_NAME");
            String lastName = intent.getStringExtra("LAST_NAME");
            String dob = intent.getStringExtra("DOB");
            String address = intent.getStringExtra("ADDRESS");
            String email = intent.getStringExtra("EMAIL");

            String displayText = "First Name: " + firstName +
                    "\nMiddle Name: " + middleName +
                    "\nLast Name: " + lastName +
                    "\nDate of Birth: " + dob +
                    "\nAddress: " + address +
                    "\nEmail: " + email;

            displayTextView.setText(displayText);
        }
    }
}
