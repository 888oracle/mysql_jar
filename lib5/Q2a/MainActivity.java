// Define Colors and Styles:
// Open your res/values/colors.xml file and define the colors you want to use. 
//Similarly, define styles in res/values/styles.xml for different font styles.
// colors.xml:

// xml
// Copy code
// <resources>
//     <color name="defaultTextColor">#000000</color>
//     <color name="customTextColor">#FF0000</color>
// </resources>
// styles.xml:

// xml
// Copy code
// <resources>
//     <style name="CustomTextStyle">
//         <item name="android:textSize">18sp</item>
//         <item name="android:textStyle">italic</item>
//     </style>
// </resources>
package com.example.slips;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView collegeNameTextView;
    private Button changePropertiesButton;

    private boolean propertiesChanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        collegeNameTextView = findViewById(R.id.collegeNameTextView);
        changePropertiesButton = findViewById(R.id.changePropertiesButton);

        changePropertiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!propertiesChanged) {
                    // Change text color to custom color
                    collegeNameTextView.setTextColor(getResources().getColor(R.color.customTextColor));

                    // Apply custom text style
                    collegeNameTextView.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));

                    // Change text size using custom style
                    collegeNameTextView.setTextAppearance(R.style.CustomTextStyle);

                    propertiesChanged = true;
                } else {
                    // Revert back to default properties
                    collegeNameTextView.setTextColor(getResources().getColor(R.color.defaultTextColor));
                    collegeNameTextView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                    collegeNameTextView.setTextSize(24); // Default text size

                    propertiesChanged = false;
                }
            }
        });
    }
}
