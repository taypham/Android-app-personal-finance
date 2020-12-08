package com.example.budgetappfinal.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.budgetappfinal.R;
import com.example.budgetappfinal.data.Database;
import com.example.budgetappfinal.presenter.BalanceActivityPresenter;
import com.example.budgetappfinal.presenter.BalanceInterface;


public class BalanceActivity extends AppCompatActivity implements BalanceInterface  {
    Database balanceData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);


    }
}