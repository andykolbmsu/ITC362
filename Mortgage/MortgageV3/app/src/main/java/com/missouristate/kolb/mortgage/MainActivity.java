package com.missouristate.kolb.mortgage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static Mortgage mortgage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mortgage = new Mortgage();
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateView();
    }

    private void updateView() {
        TextView tvAmount = findViewById(R.id.tvAmount);
        tvAmount.setText(mortgage.getFormattedAmount());
        TextView tvYears = findViewById(R.id.tvYears);
        tvYears.setText("" + mortgage.getYears());
        TextView tvRate = findViewById(R.id.tvRate);
        tvRate.setText(100 * mortgage.getRate() + "%");
        TextView tvMonthly = findViewById(R.id.tvMonthly);
        tvMonthly.setText(mortgage.formattedMonthlyPayment());
        TextView tvTotal = findViewById(R.id.tvTotal);
        tvTotal.setText(mortgage.formattedTotalPayment());
    }

    public void modifyData(View view) {

        Intent myIntent = new Intent(this, DataActivity.class);
        this.startActivity(myIntent);
        this.overridePendingTransition(R.anim.slide_from_left,0);

    }
}