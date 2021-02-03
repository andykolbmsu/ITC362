package com.missouristate.kolb.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TipCalculator tipCalc;
    private NumberFormat money = NumberFormat.getCurrencyInstance();
    private EditText billEditText;
    private EditText tipEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tipCalc = new TipCalculator(1f,1f);

        billEditText = findViewById(R.id.et_Bill);
        tipEditText = findViewById(R.id.et_Tip_Percent);

        TextChangeHandler tch = new TextChangeHandler();
        billEditText.addTextChangedListener(tch);
        tipEditText.addTextChangedListener(tch);
    }

    public void calculate() {

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


    private class TextChangeHandler implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            calculate();
        }
    }
}