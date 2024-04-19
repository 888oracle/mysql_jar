import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText numberInput;
    private TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberInput = findViewById(R.id.number_input);
        tableLayout = findViewById(R.id.table_layout);
    }

    public void showMultiplicationTable(View view) {
        // Clear existing table rows
        tableLayout.removeAllViews();

        // Get the number entered by the user
        String numberStr = numberInput.getText().toString();
        if (numberStr.isEmpty()) {
            numberInput.setError("Please enter a number");
            return;
        }

        int number = Integer.parseInt(numberStr);

        // Create and add table rows for the multiplication table
        for (int i = 1; i <= 10; i++) {
            TableRow row = new TableRow(this);

            TextView numberTextView = new TextView(this);
            numberTextView.setText(String.valueOf(number));
            numberTextView.setPadding(10, 10, 10, 10);
            row.addView(numberTextView);

            TextView multiplicationTextView = new TextView(this);
            multiplicationTextView.setText("x");
            multiplicationTextView.setPadding(10, 10, 10, 10);
            row.addView(multiplicationTextView);

            TextView multiplierTextView = new TextView(this);
            multiplierTextView.setText(String.valueOf(i));
            multiplierTextView.setPadding(10, 10, 10, 10);
            row.addView(multiplierTextView);

            TextView equalsTextView = new TextView(this);
            equalsTextView.setText("=");
            equalsTextView.setPadding(10, 10, 10, 10);
            row.addView(equalsTextView);

            TextView resultTextView = new TextView(this);
            resultTextView.setText(String.valueOf(number * i));
            resultTextView.setPadding(10, 10, 10, 10);
            row.addView(resultTextView);

            tableLayout.addView(row);
        }
    }
}
