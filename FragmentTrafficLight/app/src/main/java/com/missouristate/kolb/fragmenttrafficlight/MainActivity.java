package com.missouristate.kolb.fragmenttrafficlight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        status = 0;
    }

    public void toggle(View view) {

        TextView tvLight = findViewById(R.id.tvLight);

        status++;
        if(status == 3)
            status = 0;

        switch(status) {
            case 0:
                tvLight.setText(getString(R.string.red_light));
                tvLight.setBackgroundColor(getColor(R.color.red));
                break;
            case 1:
                tvLight.setText(getString(R.string.green_light));
                tvLight.setBackgroundColor(getColor(R.color.green));
                break;
            case 2:
                tvLight.setText(getString(R.string.yellow_light));
                tvLight.setBackgroundColor(getColor(R.color.yellow));
                break;
        }

    }
}