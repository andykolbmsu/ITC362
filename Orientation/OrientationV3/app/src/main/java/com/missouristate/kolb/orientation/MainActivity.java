package com.missouristate.kolb.orientation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public final static String MA = "MainActivity";
    public final static int SPACING_VERTICAL = 150;
    public final static int SPACING_HORIZONTAL = 25;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.w(MA,"Inside onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Configuration config = getResources().getConfiguration();
        modifyLayout(config);
    }

    private void modifyLayout(Configuration newConfig) {
        Log.w(MA,"Inside modifyLayout");

        Button b2 = findViewById(R.id.button2);
        ViewGroup.MarginLayoutParams params2 = (ViewGroup.MarginLayoutParams) b2.getLayoutParams();
        Button b3 = findViewById(R.id.button3);
        ViewGroup.MarginLayoutParams params3 = (ViewGroup.MarginLayoutParams) b3.getLayoutParams();

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            params2.setMargins(0,SPACING_HORIZONTAL,0,0);
            params3.setMargins(0,SPACING_HORIZONTAL,0,0);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            params2.setMargins(0,SPACING_VERTICAL,0,0);
            params3.setMargins(0,SPACING_VERTICAL,0,0);
        }
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        Log.w(MA,"Inside onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
        modifyLayout(newConfig);
    }
}