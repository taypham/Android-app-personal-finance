package com.example.budgetappfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

public class BudgetActivity extends AppCompatActivity {
    private EditText amount;
    private Spinner spCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

        amount = (EditText) findViewById(R.id.edtAmount);
    }
}