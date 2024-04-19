package com.example.stringoperation_radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    // These are the global variables
    RadioGroup radioGroup;
    RadioButton rb1, rb2, rb3, rb4;
    RadioButton selectedRadioButton;
    Button buttonSubmit;
    TextView tvRg3, tvRg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // layout instances
        buttonSubmit = (Button) findViewById(R.id.btn_submit);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        rb4 = (RadioButton) findViewById(R.id.rb4);
        tvRg3 = findViewById(R.id.tvRg3);
        tvRg1 = findViewById(R.id.tvRg1);
         /*
            Submit Button
        */
        buttonSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Get the selected RadioButton
                selectedRadioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                // get RadioButton text
                String yourVote = selectedRadioButton.getText().toString();
                String radioButtonChoices = "";

                //String Rg3,Rg1;

                if (rb1.isChecked()) {

                   radioButtonChoices += tvRg1.getText().toString();
                   tvRg3.setText(radioButtonChoices.toUpperCase(Locale.ROOT));

                }
                else {
                }

                if (rb2.isChecked()) {
                    radioButtonChoices += tvRg1.getText().toString();
                    tvRg3.setText(radioButtonChoices.toLowerCase(Locale.ROOT));
                } else {

                }

                if (rb3.isChecked()) {
                    radioButtonChoices += tvRg1.getText().toString();
                    tvRg3.setText(radioButtonChoices.substring(tvRg1.length()-5, tvRg1.length()));
                } else {

                }
                if (rb4.isChecked()) {
                    radioButtonChoices += tvRg1.getText().toString();
                    tvRg3.setText(radioButtonChoices.substring(0,5));
                } else {

                }
            }
        });
    }
}
