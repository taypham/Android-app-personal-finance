package com.example.budgetappfinal.presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.budgetappfinal.data.AnalysisDao;
import com.example.budgetappfinal.data.Database;
import com.example.budgetappfinal.data.TransactionDao;
import com.example.budgetappfinal.model.Budget;
import com.example.budgetappfinal.model.BudgetAnalysis;
import com.example.budgetappfinal.model.Transaction;

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
    // Responsible for debiting the account or credit card
    public void updatebudgetspent() {
        BudgetAnalysis b;
        String amount = tView.getTransAmount();
        String category = tView.getTransCategory();
        b = AnalysisDao.selectBudget(category);
        b.setBudgetSpent( b.getBudgetSpent() + Double.parseDouble(amount) );
        AnalysisDao.updateTransaction(b);
    }
}
