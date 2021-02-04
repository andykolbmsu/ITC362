package com.missouristate.kolb.burgercaloriecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declare UI objects and variables
    private RadioGroup rgPatty;
    private CheckBox cbProsciutto;
    private RadioGroup rgCheese;
    private SeekBar sbSauce;
    private TextView tvCalories;

    private Burger burger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI objects and variables
        burger = new Burger();
        initialize();

        // Register change listeners
        registerChangeListeners();
    }


    private void initialize() {
        rgPatty = findViewById(R.id.radioGroup1);
        cbProsciutto = findViewById(R.id.checkBox1);
        rgCheese = findViewById(R.id.radioGroup2);
        sbSauce = findViewById(R.id.seekBar1);
        tvCalories = findViewById(R.id.textView2);

        displayCalories();
    }


    private void registerChangeListeners() {
        rgPatty.setOnCheckedChangeListener(foodListener);
        cbProsciutto.setOnClickListener(baconListener);
        rgCheese.setOnCheckedChangeListener(foodListener);
        sbSauce.setOnSeekBarChangeListener(sauceListener);
    }


    private RadioGroup.OnCheckedChangeListener foodListener = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup rbGroup, int radioId) {
            RadioButton rb = findViewById(radioId);
            String btn = rb.getText().toString();

            switch (btn) {
                case "Beef Patty":
                    burger.setPattyCalories(Burger.BEEF);
                    break;
                case "Lamb Patty":
                    burger.setPattyCalories(Burger.LAMB);
                    break;
                case "Ostrich Patty":
                    burger.setPattyCalories(Burger.OSTRICH);
                    break;
                case "Asiago Cheese":
                    burger.setCheeseCalories(Burger.ASIAGO);
                    break;
                case "Creme Fraiche":
                    burger.setCheeseCalories(Burger.CREME_FRAICHE);
            }
            displayCalories();
        }
    };

    private View.OnClickListener baconListener = new View.OnClickListener() {
        public void onClick(View v) {
            if(((CheckBox) v).isChecked()) {
                burger.setProsciuttoCalories(Burger.PROSCIUTTO);
            } else {
                burger.clearProsciuttoCalories();
            }
            displayCalories();
        }
    };

    private SeekBar.OnSeekBarChangeListener sauceListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            burger.setSauceCalories(seekBar.getProgress());
            displayCalories();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {}

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {}
    };


    private void displayCalories() {
        String calorieText = "Calories: " + burger.getTotalCalories();
        tvCalories.setText(calorieText);
    }


}