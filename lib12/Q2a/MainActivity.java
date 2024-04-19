package com.example.slips;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton selectedRadioButton;
    Button buttonSubmit;
    CheckBox cb1, cb2, cb3, cb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSubmit = (Button) findViewById(R.id.btnSubmit);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        cb3 = (CheckBox) findViewById(R.id.cb3);
        cb4 = (CheckBox) findViewById(R.id.cb4);

        /*
            Submit Button
        */
        buttonSubmit.setOnClickListener(v -> {
            //Get the selected RadioButton
            selectedRadioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
            // get RadioButton text
            String yourVote = selectedRadioButton.getText().toString();

            String checkBoxChoices = "";

            if (cb1.isChecked()) {
                checkBoxChoices += cb1.getText().toString() + "\t: " +
                        "YES\n";
            } else {
                checkBoxChoices += cb1.getText().toString() + "\t: NO\n";
            }

            if (cb2.isChecked()) {
                checkBoxChoices += cb2.getText().toString() + "\t: YES\n";
            } else {
                checkBoxChoices += cb2.getText().toString() + "\t: NO\n";
            }

            if (cb3.isChecked()) {
                checkBoxChoices += cb3.getText().toString() + "\t: YES\n";
            } else {
                checkBoxChoices += cb3.getText().toString() + "\t: NO\n";
            }

            if (cb4.isChecked()) {
                checkBoxChoices += cb4.getText().toString() + "\t: YES\n";
            } else {
                checkBoxChoices += cb4.getText().toString() + "\t: NO\n";
            }

            // display it as Toast to the user

            Toast.makeText(MainActivity.this, "Selected Radio Button is:" + yourVote+ "\n CheckBox Choices: \n "+checkBoxChoices,Toast.LENGTH_LONG).show();


        });
    }
}
