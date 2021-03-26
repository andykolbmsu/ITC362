package com.missouristate.kolb.fragmenttrafficlights;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private  int status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        status = 0;
    }

    public void toggleLight(View view) {

        // define all lights
        LinearLayout redLight = findViewById(R.id.redLight);
        LinearLayout yellowLight = findViewById(R.id.yellowLight);
        LinearLayout greenLight = findViewById(R.id.greenLight);

        // set all light transparency to 0
        redLight.setAlpha(0);
        yellowLight.setAlpha(0);
        greenLight.setAlpha(0);

        // change light status
        status++;
        if(status == 3)
            status = 0;

        // turn on correct light
        switch(status) {
            case 0:
                redLight.setAlpha(1);
                break;
            case 1:
                greenLight.setAlpha(1);
                break;
            case 2:
                yellowLight.setAlpha(2);
                break;
        }

    }
}