package com.example.budgetappfinal.presenter;

import android.content.Context;

import com.example.budgetappfinal.data.Database;
import com.example.budgetappfinal.data.TransactionDao;
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
        //Database db = new Database(c,null,null,1);

        String description = tView.getTransDescription();
        String amount = tView.getTransAmount();
        String category = tView.getTransCategory();
        String dateRecorded = tView.getTransActualDate();

        if ( !description.equals("") && !category.equals("")&& !amount.equals("")  &&
                !dateRecorded.equals("")) {

            if ( transaction.insertTransaction( description, category,  Float.parseFloat(amount), dateRecorded ) ) {
               // debiting();
                tView.successInserted();
                return true;
            } else {
                tView.dbInsertError();
                return false;
            }
        } else {
            tView.registrationError();
            return false;
        }
    }
}
