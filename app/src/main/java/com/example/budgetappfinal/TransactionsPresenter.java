package com.example.budgetappfinal;

import android.content.Context;

public class TransactionsPresenter {
    TransactionsInterface mView;
    Context c;

    public TransactionsPresenter (TransactionsInterface view, Context context) {
        this.mView = view;
        this.c = context;
    }
    public void Transaction() {
        String description = mView.getDescription();
        String amount = mView.getAmount();
        String category = mView.getCategory();
        String actualDate = mView.getActualDate();


        if (!description.equals("") && !amount.equals("") && !category.equals("") &&
                !actualDate.equals("")) {

           /* if (spending.insertSpending(description, Float.parseFloat(amount), actualDate, category)) {
                mView.successInserted();
                return true;
            } else {
                mView.dbInsertError();
                return false;
            }*/
        }
    }
}
