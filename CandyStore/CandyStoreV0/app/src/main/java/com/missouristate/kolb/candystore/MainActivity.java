package com.missouristate.kolb.candystore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle action bar item clicks

        int id = item.getItemId();
        switch (id) {
            case R.id.action_add:
                Log.w("MainActivity", "Add selected");
                return true;
            case R.id.action_delete:
                Log.w("MainActivity", "Deleted selected");
                return true;
            case R.id.action_update:
                Log.w("MainActivity", "Update selected");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}