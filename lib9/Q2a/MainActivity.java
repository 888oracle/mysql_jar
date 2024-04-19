package com.example.slips;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    private EditText firstNameEditText, lastNameEditText, addressEditText, phoneEditText, emailEditText;
    private RadioGroup genderRadioGroup;
    private RadioButton maleRadioButton, femaleRadioButton;
    private Button submitButton, clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        addressEditText = findViewById(R.id.addressEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        emailEditText = findViewById(R.id.emailEditText);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        maleRadioButton = findViewById(R.id.maleRadioButton);
        femaleRadioButton = findViewById(R.id.femaleRadioButton);
        submitButton = findViewById(R.id.submitButton);
        clearButton = findViewById(R.id.clearButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = String.valueOf(firstNameEditText.getText());
                String lastName = String.valueOf(lastNameEditText.getText());
                String address = String.valueOf(addressEditText.getText());
                String phone = String.valueOf(phoneEditText.getText());
                String email = String.valueOf(emailEditText.getText());
                String gender = "";

                if (maleRadioButton.isChecked()) {
                    gender = "Male";
                } else if (femaleRadioButton.isChecked()) {
                    gender = "Female";
                }

                Toast.makeText(MainActivity.this, "First Name: " + firstName + "\nLast Name: " + lastName + "\nAddress: " + address + "\nPhone: " + phone + "\nEmail: " + email + "\nGender: " + gender, Toast.LENGTH_LONG).show();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNameEditText.setText("");
                lastNameEditText.setText("");
                addressEditText.setText("");
                phoneEditText.setText("");
                emailEditText.setText("");
                genderRadioGroup.clearCheck();
            }
        });
    }
}