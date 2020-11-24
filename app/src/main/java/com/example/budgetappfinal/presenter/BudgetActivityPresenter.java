package com.example.budgetappfinal.presenter;
import android.content.Context;
import android.widget.Toast;

import com.example.budgetappfinal.data.AnalysisDao;
import com.example.budgetappfinal.data.BudgetDao;
import com.example.budgetappfinal.presenter.BudgetInterface;

public class BudgetActivityPresenter {
    BudgetInterface bView;
    Context c;
    public BudgetActivityPresenter(BudgetInterface view, Context context) {
        this.bView = view;
        this.c = context;
    }
    public boolean insertBudget() {
        BudgetDao budget = new BudgetDao(c);
        AnalysisDao analysisDao = new AnalysisDao(c);

        String amount = bView.getBudgetAmount();
        String category = bView.getBudgetCategory();
        Double spent = 0.0;
        Double balance = Double.parseDouble(amount);
        Double progress = 0.0;

        if ( !amount.equals("") && !category.equals("")) {

            if ( budget.insertBudget(Integer.parseInt(amount),category)) {
                Toast.makeText(c.getApplicationContext(), "Budget added", Toast.LENGTH_SHORT).show();
                analysisDao.insertBudgetForAnalysis(category,Integer.parseInt(amount),spent,balance, progress );
                return true;
            } else {
                Toast.makeText(c.getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else {
            Toast.makeText(c.getApplicationContext(), "Missing content", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}
