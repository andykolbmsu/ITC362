package com.missouristate.kolb.countapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void addToCounter(View view) {
        Button btn_tap = findViewById(R.id.btn_Tap);
        TextView tv_count = findViewById(R.id.tv_Count);

        String countString = tv_count.getText().toString();
        Integer countInt = Integer.parseInt(countString);

        Integer countUpdate = Counter.increaseCount(countInt);

        tv_count.setText(countUpdate.toString());
    }
}