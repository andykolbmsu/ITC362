package com.missouristate.kolb.mortgage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        updateDataView();
    }

    private void updateDataView() {
        Mortgage mortgage = MainActivity.mortgage;
        if(mortgage.getYears() == 10) {
            RadioButton rbTen = findViewById(R.id.rbTen);
            rbTen.setChecked(true);
        } else if(mortgage.getYears() == 15) {
            RadioButton rbFifteen = findViewById(R.id.rbFifteen);
            rbFifteen.setChecked(true);
        }

        EditText etAmount = findViewById(R.id.etDataAmount);
        etAmount.setText("" + mortgage.getAmount());
        EditText etRate = findViewById(R.id.etDataRate);
        etRate.setText("" + mortgage.getRate());
    }


    public void goBack(View view) {
        updateMortgageObject();
        this.finish();
    }

    private void updateMortgageObject() {
        Mortgage mortgage = MainActivity.mortgage;
        RadioButton rbTen = findViewById(R.id.rbTen);
        RadioButton rbFifteen = findViewById(R.id.rbFifteen);
        int years = 30;
        if(rbTen.isChecked()) {
            years = 10;
        } else if (rbFifteen.isChecked()) {
            years = 15;
        }
        mortgage.setYears(years);

        EditText etAmount = findViewById(R.id.etDataAmount);
        String amountString = etAmount.getText().toString();
        EditText etRate = findViewById(R.id.etDataRate);
        String rateString = etRate.getText().toString();
        try {
            float amount = Float.parseFloat(amountString);
            mortgage.setAmount(amount);
            float rate = Float.parseFloat(rateString);
            mortgage.setRate(rate);
        } catch (NumberFormatException nfe) {
            mortgage.setAmount(100000.0f);
            mortgage.setRate(.035f);
        }
    }
}