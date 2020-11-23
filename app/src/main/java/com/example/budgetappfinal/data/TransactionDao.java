package com.example.budgetappfinal.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.budgetappfinal.model.Budget;
import com.example.budgetappfinal.data.Database;

import java.util.ArrayList;

public class TransactionDao {
    private Database database;

    public TransactionDao(Context context) {
        database = new Database(context);
    }

    public boolean insertTransaction(String description, String category, Float amount, String date) {
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("description", description);
        contentValues.put("category", category);
        contentValues.put("amount", amount);
        contentValues.put("date", date);
        long result = db.insert(Database.TABLE_TRANSACTIONS, null, contentValues);
        db.close();
        if ( result == -1 )
            return false;
        else
            return true;
    }
    //Update Balance send a call to balance table and update it.
    public void updateBalance(){}
}