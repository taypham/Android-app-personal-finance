package com.example.budgetappfinal.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.budgetappfinal.R;
import com.example.budgetappfinal.data.BalanceDao;
import com.example.budgetappfinal.data.Database;
import com.example.budgetappfinal.data.TransactionDao;
import com.example.budgetappfinal.model.Balance;
import com.example.budgetappfinal.presenter.BalanceActivityPresenter;
import com.example.budgetappfinal.presenter.BalanceInterface;


public class BalanceActivity extends AppCompatActivity implements BalanceInterface  {
    Database balanceData;
    private EditText etAmount;
    private Button btnSummit;
    BalanceDao balance;
    Balance b;
    BalanceDao bDao;
    TextView tvBalance;
    TextView totalIncome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);
        etAmount = (EditText) findViewById(R.id.edtAddIncome);
        btnSummit = (Button)findViewById(R.id.btnSubmit);
        tvBalance = (TextView) findViewById(R.id.tvBalanceShow);
        totalIncome = (TextView)findViewById(R.id.tvAmount);
        bDao = new BalanceDao(this);

        btnSummit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertIncome();
                printOutBalance();

            }
        });
    }
    public void printOutBalance(){
        Balance b = bDao.requestBalance();
        tvBalance.setText(String.valueOf(b.getBalance()));
        totalIncome.setText(String.valueOf(b.getIncome()));
    }
    public void insertIncome(){
        bDao.insertIncome(Double.parseDouble(etAmount.getText().toString()), Double.parseDouble(etAmount.getText().toString()));
    }


    public double getIncomeAmount() {
        return Double.parseDouble(etAmount.getText().toString());
    }

}

