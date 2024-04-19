package com.example.slips;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        registerForContextMenu(imageView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_red:
                imageView.setColorFilter(getResources().getColor(R.color.red));
                return true;
            case R.id.menu_green:
                imageView.setColorFilter(getResources().getColor(R.color.green));
                return true;
            case R.id.menu_blue:
                imageView.setColorFilter(getResources().getColor(R.color.blue));
                return true;
            case R.id.menu_clear:
                imageView.setColorFilter(null);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}