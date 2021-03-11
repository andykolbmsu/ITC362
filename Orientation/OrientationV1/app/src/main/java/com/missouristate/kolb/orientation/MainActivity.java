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

public class MainActivity extends AppCompatActivity {

    public final static String MA = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Log.w(MA, "Height: " + newConfig.screenHeightDp);
        Log.w(MA, "Width: " + newConfig.screenWidthDp);

        Log.w(MA,"Orientation: " + newConfig.orientation);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
            Log.w(MA,"Horizontal position");
        else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
            Log.w(MA,"Vertical position");
        else
            Log.w(MA,"Undetermined position");
    }
}