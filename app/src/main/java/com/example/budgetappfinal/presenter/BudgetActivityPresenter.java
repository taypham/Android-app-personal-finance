package com.example.budgetappfinal.presenter;
import android.content.Context;

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
        BudgetDao budget = new BudgetDao(c,null,null,1);

        String amount = bView.getBudgetAmount();
        String category = bView.getBudgetCategory();

        if (  !amount.equals("") && !category.equals("")) {

            if ( budget.insertBudget(Integer.parseInt(amount),category) ) {
                bView.inserted();
                return true;
            } else {
                bView.databaseInsertError();
                return false;
            }
        } else {
            bView.registrationError();
            return false;
        }
    }
}
