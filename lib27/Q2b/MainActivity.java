// in output u will see a text field of enter number
//long press on that field and 2 options will be visible of factorial and sum of digits
package com.example.slips;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    EditText numEditText;
    TextView factorialTextView, sumTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numEditText = (EditText) findViewById(R.id.numEditText);
        factorialTextView = (TextView) findViewById(R.id.factorialTextView);
        sumTextView = (TextView) findViewById(R.id.sumTextView);

        registerForContextMenu(numEditText);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 1, 0, "Calculate Factorial");
        menu.add(0, 2, 0, "Calculate Sum of Digits");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == 1) {
            int num = Integer.parseInt(numEditText.getText().toString());
            long factorial = 1;
            for (int i = 2; i <= num; i++) {
                factorial *= i;
            }
            factorialTextView.setText("Factorial: " + factorial);
            return true;
        } else if (item.getItemId() == 2) {
            int num = Integer.parseInt(numEditText.getText().toString());
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            sumTextView.setText("Sum of Digits: " + sum);
            return true;
        }

        return super.onContextItemSelected(item);
    }
}