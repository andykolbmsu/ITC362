package com.missouristate.kolb.trafficlightapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private int state = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleLight();
    }

    public void buttonPress (View view) {
        //  Add to state, reset to 0 if state == 3
        state++;
        if (state == 3) { state = 0; }

        toggleLight();
    }

    public void toggleLight() {

        //  Set up variables for button, colors, and lights
        Button button = findViewById(R.id.button);
        int colorStop = getColor(R.color.stop);
        int colorWait = getColor(R.color.wait);
        int colorGo  = getColor(R.color.go);
        int colorGrey = getColor(R.color.colorPrimaryDark);

        ImageView stopLight = findViewById(R.id.iv_StopLight);
        ImageView goLight = findViewById(R.id.iv_GoLight);
        ImageView waitLight = findViewById(R.id.iv_WaitLight);

        //  Reset lights to default grey
        stopLight.setColorFilter(colorGrey);
        goLight.setColorFilter(colorGrey);
        waitLight.setColorFilter(colorGrey);

        // Determine state and change text and colors
        if(state == 0) {                //  STOP
            button.setText("Stop");
            button.setBackgroundColor(colorStop);
            stopLight.setColorFilter(colorStop);
        } else if (state == 1) {        //  GO
            button.setText("Go");
            button.setBackgroundColor(colorGo);
            goLight.setColorFilter(colorGo);
        } else if (state == 2) {        //  WAIT
            button.setText("Wait");
            button.setBackgroundColor(colorWait);
            waitLight.setColorFilter(colorWait);
        }

    }

}