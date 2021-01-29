package com.missouristate.kolb.hellogoodbye;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String MA = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Log.w(MA,"View resource:" + R.layout.activity_main);


        int count = 0;
        for(int i=0;i<3;i++){
            count++;
        }
    }

    public void changeMessage(View view) {
        ImageView hello = findViewById(R.id.elephant_hello);
        ImageView goodbye = findViewById(R.id.elephant_goodbye);
        TextView message = findViewById(R.id.message);

        hello.setVisibility(View.INVISIBLE);
        goodbye.setVisibility(View.VISIBLE);

        message.setText("GoodBye");
    }




}