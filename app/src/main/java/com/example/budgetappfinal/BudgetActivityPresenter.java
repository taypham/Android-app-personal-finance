package com.example.budgetappfinal;
import android.content.Context;
import com.example.budgetappfinal.BudgetInterface;
import com.example.budgetappfinal.BudgetInterface;

public class BudgetActivityPresenter {
    BudgetInterface bView;
    Context c;
    public BudgetActivityPresenter(BudgetInterface view, Context context) {
        this.bView = view;
        this.c = context;
    }
    public boolean budgetRegistration() {
        BudgetDao budget = new BudgetDao(c);


        String amount = bView.getbudgetAmount();
        String category = bView.getbudgetCategory();

        if (  !amount.equals("") && !category.equals("")) {

            if ( budget.insertBudget(Float.parseFloat(amount),category) ) {
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
