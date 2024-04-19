//Add this file name in manifest in place of MainActivity

package com.example.slips;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    EditText firstNameEditText, middleNameEditText, lastNameEditText,
            dobEditText, addressEditText, emailEditText;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        firstNameEditText = findViewById(R.id.firstNameEditText);
        middleNameEditText = findViewById(R.id.middleNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        dobEditText = findViewById(R.id.dobEditText);
        addressEditText = findViewById(R.id.addressEditText);
        emailEditText = findViewById(R.id.emailEditText);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = firstNameEditText.getText().toString();
                String middleName = middleNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String dob = dobEditText.getText().toString();
                String address = addressEditText.getText().toString();
                String email = emailEditText.getText().toString();

                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("FIRST_NAME", firstName);
                intent.putExtra("MIDDLE_NAME", middleName);
                intent.putExtra("LAST_NAME", lastName);
                intent.putExtra("DOB", dob);
                intent.putExtra("ADDRESS", address);
                intent.putExtra("EMAIL", email);
                startActivity(intent);
            }
        });
    }
}
