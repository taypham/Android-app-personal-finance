package com.example.budgetappfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.budgetappfinal.view.AnalysisActivity;
import com.example.budgetappfinal.view.BalanceActivity;
import com.example.budgetappfinal.view.BudgetActivity;
import com.example.budgetappfinal.view.TransactionHistory;
import com.example.budgetappfinal.view.TransactionsActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnBudget;
    private Button btnTransctions;
    private Button btnAnalysis;
    private Button btnBalance;
    private Button btnTransHistory;
    //Tay Pham Comment
    // Laura Comment
    // Ailin Comment//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBudget =  findViewById(R.id.btnBudget);
        btnTransctions =  findViewById(R.id.btnTransactions);
        btnBalance =  findViewById(R.id.btnBalance);
        btnAnalysis =  findViewById(R.id.btnAnalysis);
        btnTransHistory =findViewById(R.id.btnTransHistory);

        btnBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BudgetActivity.class);
                startActivity(intent);

            }
        });
        btnTransctions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TransactionsActivity.class);
                startActivity(intent);

            }
        });
        btnBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BalanceActivity.class);
                startActivity(intent);

            }
        });
        btnAnalysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnalysisActivity.class);
                startActivity(intent);

            }
        });
        btnTransHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TransactionHistory.class);
                startActivity(intent);

            }
        });
    }
}