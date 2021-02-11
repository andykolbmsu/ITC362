package com.missouristate.kolb.shades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layout;
    private Button[] buttons;
    private int COUNT = 3;
    private String[] labels;
    private boolean messageExists = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  get width of screen
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int w = size.x;

        // create and populate button label array
        labels = new String[COUNT];
        populateLabelArray();

        // rewrite app title
        this.setTitle("Shades v1");

        // create linear layout
        layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.parseColor("#c89b6d"));
        layout.setPadding(0,40,0,0);

        // create button array and buttonhandler
        buttons = new Button[COUNT];
        ButtonHandler bh = new ButtonHandler();

        // apply parameters to all three buttons and add them to layout view
        for(int i = 0; i < COUNT; i++) {
            buttons[i] = new Button(this);
            buttons[i].setText(labels[i]);
            buttons[i].setBackgroundColor(Color.parseColor("#ac7d50"));
            buttons[i].setOnClickListener(bh);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(w,w/4);
            if(i == 2) {
                params.setMargins(0,0,0,40);
            } else {
                params.setMargins(0,0,0,10);
            }

            layout.addView(buttons[i], params);
        }

        // render linear layout
        setContentView(layout);

    }

    private void populateLabelArray() {
        labels[0] = "Plum";
        labels[1] = "Blue";
        labels[2] = "Gold";
    }

    private class ButtonHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String buttonText;
            String messageText = "";
            Log.w("MainActivity", "Inside onClick, v=" + v);

            for(int i = 0; i < COUNT; i++) {
                if(v == buttons[i]) {
                    buttonText = (String) buttons[i].getText();
                    update(buttonText);
                }
            }
        }
    }

    private void update(String buttonText) {
        TextView message;
        int tvId = 8888;
        String messageText = "";

        switch(buttonText) {
            case "Plum":
                messageText = getResources().getString(R.string.plum_is);
                break;
            case "Blue":
                messageText = getResources().getString(R.string.blue_is);
                break;
            case "Gold":
                messageText = getResources().getString(R.string.gold_is);
        }

        if (messageExists) {
            // sets message text to existing textview
            message = layout.findViewById(tvId);
            message.setText(messageText);
        } else {
            // creates new textview with relevant message text
            message = new TextView(this);
            message.setBackgroundColor(Color.parseColor("#ac7d50"));
            message.setGravity(Gravity.CENTER);
            message.setPadding(0,200,0,200);
            message.setId(tvId);
            message.setText(messageText);
            layout.addView(message);
            messageExists = true;
        }
    }
}