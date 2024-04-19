package com.example.slips;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et_user=findViewById(R.id.et_user);
        EditText et_pass=findViewById(R.id.et_pass);
        Button bt_okay=findViewById(R.id.bt_okay);
        Button bt_cancel=findViewById(R.id.bt_cancel);

        bt_okay.setOnClickListener(view -> {
            String user=et_user.getText().toString();
            String pass=et_pass.getText().toString();
            if (user.equals("admin")&& pass.equals("admin")) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        });

        bt_cancel.setOnClickListener(view -> {
            et_user.getText().clear();
            et_pass.getText().clear();
        });

    }
}