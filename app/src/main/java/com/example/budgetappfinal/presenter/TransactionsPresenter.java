package com.example.budgetappfinal.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.budgetappfinal.data.AnalysisDao;
import com.example.budgetappfinal.data.BalanceDao;
import com.example.budgetappfinal.data.BudgetDao;
import com.example.budgetappfinal.data.Database;
import com.example.budgetappfinal.data.TransactionDao;
import com.example.budgetappfinal.model.Balance;
import com.example.budgetappfinal.model.Budget;
import com.example.budgetappfinal.model.BudgetAnalysis;
import com.example.budgetappfinal.model.Transaction;
import com.example.budgetappfinal.view.BalanceActivity;

import java.util.ArrayList;

public class TransactionsPresenter {
    TransactionsInterface tView;
    Context c;

    public TransactionsPresenter (TransactionsInterface view, Context context) {
        this.tView = view;
        this.c = context;

    }
    public boolean insertTransaction() {
        TransactionDao transaction = new TransactionDao(c);


        String description = tView.getTransDescription();
        String amount = tView.getTransAmount();
        String category = tView.getTransCategory();
        String dateRecorded = tView.getTransActualDate();

        if ( !description.equals("") && !category.equals("")&& !amount.equals("")  &&
                !dateRecorded.equals("")) {

            if ( transaction.insertTransaction( description, category,  Double.parseDouble(amount), dateRecorded ) ) {
                updatebudgetspent();
                Toast.makeText(c.getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
                return true;
            } else {
                Toast.makeText(c.getApplicationContext(), "add transaction failed", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else {
            Toast.makeText(c.getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    public void updatebudgetspent() {
        BudgetAnalysis b;
        String amount = tView.getTransAmount();
        String category = tView.getTransCategory();
        b = AnalysisDao.selectBudget(category);
        b.setAmountSpent( b.getAmountSpent() + Double.parseDouble(amount) );
        b.setBudgetBalance(b.getBudgetAmount()- b.getAmountSpent());
        b.setProgress(b.getAmountSpent()/b.getBudgetAmount());
        AnalysisDao.updateAfterTransaction(b);


    }

    public void updateBalanceTable() {
        //Toast.makeText(c.getApplicationContext(), "Update Balance table running", Toast.LENGTH_SHORT).show();
        //Balance b = new Balance(0.0,0.0);
        //double amount = Double.parseDouble(tView.getTransAmount());
        //b = BalanceDao.requestBalance();
        //b.setIncome(b.getIncome());
       // b.setBalance(b.getBalance()-amount);
        //Log.d("MainActivity","b get Income: ");

        //BalanceDao.updateAfterTransaction(b);
    }
}
