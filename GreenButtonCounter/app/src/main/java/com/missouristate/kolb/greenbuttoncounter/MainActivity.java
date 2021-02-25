package com.missouristate.kolb.greenbuttoncounter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize count
        count = 0;
        updateButton();
    }

    private void updateButton() {
        Button countBtn = findViewById(R.id.countBtn);
        countBtn.setText("" + count);
    }


    public void callBackActivity(View view) {
        Intent backIntent = new Intent(this, BackActivity.class);
        this.startActivityForResult(backIntent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //  Add 1 to count and update button
        count++;
        updateButton();
    }


}