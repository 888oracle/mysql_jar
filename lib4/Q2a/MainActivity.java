

//Add DisplayActivity.java in manifest file
// <activity
//android:name=".DisplayActivity"
//android:exported="true">
//</activity>

package com.example.slips;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText, surnameEditText, classEditText, hobbiesEditText, marksEditText;
    private RadioGroup genderRadioGroup;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        surnameEditText = findViewById(R.id.surnameEditText);
        classEditText = findViewById(R.id.classEditText);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        hobbiesEditText = findViewById(R.id.hobbiesEditText);
        marksEditText = findViewById(R.id.marksEditText);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayDetails();
            }
        });
    }

    private void displayDetails() {
        String name = nameEditText.getText().toString();
        String surname = surnameEditText.getText().toString();
        String studentClass = classEditText.getText().toString();
        RadioButton selectedGender = findViewById(genderRadioGroup.getCheckedRadioButtonId());
        String gender = selectedGender.getText().toString();
        String hobbies = hobbiesEditText.getText().toString();
        String marks = marksEditText.getText().toString();

        Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("surname", surname);
        intent.putExtra("class", studentClass);
        intent.putExtra("gender", gender);
        intent.putExtra("hobbies", hobbies);
        intent.putExtra("marks", marks);
        startActivity(intent);
    }
}
