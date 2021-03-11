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
        Log.w(MA,"Inside onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Configuration config = getResources().getConfiguration();
        modifyLayout(config);
    }

    private void modifyLayout(Configuration newConfig) {
        Log.w(MA,"Inside modifyLayout");

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
            setContentView(R.layout.activity_main_landscape);
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
            setContentView(R.layout.activity_main);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        Log.w(MA,"Inside onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
        modifyLayout(newConfig);
    }
}