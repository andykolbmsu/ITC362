package com.missouristate.kolb.candystore;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InsertActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
    }

    public void insert(View view) {
        Log.w("InsertActivity", "Insert button pushed");
        // get name and price
        EditText etName = findViewById(R.id.etName);
        EditText etPrice = findViewById(R.id.etPrice);
        String name = etName.getText().toString();
        String priceString = etPrice.getText().toString();

        // insert into db

        // clear data
        etName.setText("");
        etPrice.setText("");
    }

    public void goBack(View view) {
        this.finish();
    }
}
