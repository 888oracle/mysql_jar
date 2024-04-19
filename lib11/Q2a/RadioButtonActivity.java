

//Add in manifest file
// <activity
//android:name=".RadioButtonActivity"
// android:exported="true">
// if file after running causes error 
//delete the (if exists) activity_main file and run again
package com.example.slips;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class RadioButtonActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioOption1, radioOption2;
    private Button btnShowSelection;
    private TextView tvSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        radioGroup = findViewById(R.id.radioGroup);
        radioOption1 = findViewById(R.id.radioOption1);
        radioOption2 = findViewById(R.id.radioOption2);
        btnShowSelection = findViewById(R.id.btnShowSelection);
        tvSelection = findViewById(R.id.tvSelection);

        btnShowSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    tvSelection.setText("No option selected");
                } else {
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedText = selectedRadioButton.getText().toString();
                    tvSelection.setText("Selected Option: " + selectedText);
                }
            }
        });
    }
}

