package com.example.nftcentral;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.action_favorite) {
            Toast toast = Toast.makeText(getApplicationContext(), "yo", Toast.LENGTH_SHORT);
            toast.show();
            // Favorites was pressed!
        } else if (itemId == R.id.action_settings) {
            Toast toast = Toast.makeText(getApplicationContext(), "yo2", Toast.LENGTH_SHORT);
            toast.show();
            // Settings was pressed!
        }
        return super.onOptionsItemSelected(item);
    }


}