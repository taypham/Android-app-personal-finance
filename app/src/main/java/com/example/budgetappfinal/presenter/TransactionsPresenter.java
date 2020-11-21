package com.example.budgetappfinal.presenter;

import android.content.Context;

import com.example.budgetappfinal.data.TransactionDao;
import com.example.budgetappfinal.model.Transaction;

public class TransactionsPresenter {
    TransactionsInterface mView;
    Context c;

    public TransactionsPresenter (TransactionsInterface view, Context context) {
        this.mView = view;
        this.c = context;
    }
    public boolean insertTransaction() {
        TransactionDao transaction = new TransactionDao(c,null, null,1);

        String description = mView.getTransDescription();
        String amount = mView.getTransAmount();
        String category = mView.getTransCategory();
        String dateRecorded = mView.getTransActualDate();

        if ( !description.equals("") && !category.equals("")&& !amount.equals("")  &&
                !dateRecorded.equals("")) {

            if ( transaction.insertTransaction( description, category,  Float.parseFloat(amount), dateRecorded ) ) {
               // debiting();
                mView.successInserted();
                return true;
            } else {
                mView.dbInsertError();
                return false;
            }
        } else {
            mView.registrationError();
            return false;
        }
    }
}
