package com.missouristate.kolb.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TipCalculator tipCalc;
    private NumberFormat money = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tipCalc = new TipCalculator(1f,1f);
    }

    public void calculate(View v) {
        Log.w("MainActivity", "v = " + v);

        EditText billEditText = findViewById(R.id.et_Bill);
        EditText tipEditText = findViewById(R.id.et_Tip_Percent);

        String billString = billEditText.getText().toString();
        String tipString = tipEditText.getText().toString();

        TextView tipTextView = findViewById(R.id.tv_Tip_Amount);
        TextView totalTextView = findViewById(R.id.tv_Total);

        try {

            // convert strings to floats
            float billAmount = Float.parseFloat(billString);
            int tipPercent = Integer.parseInt(tipString);

            // update Model
            tipCalc.setBill(billAmount);
            tipCalc.setTip(.01f * tipPercent);

            // calculate in Model
            float tip = tipCalc.tipAmount();
            float total = tipCalc.totalAmount();

            // update View
            tipTextView.setText(money.format(tip));
            totalTextView.setText(money.format(total));

        } catch (NumberFormatException nfe) {
            // alert message
        }

    }


}