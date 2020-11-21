package com.example.budgetappfinal.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.budgetappfinal.model.Budget;

import java.util.ArrayList;

public class TransactionDao {
    private Database database;

    public TransactionDao(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        database = new Database(context,null,null,1);
    }

    public boolean insertTransaction(String description, String category, Float amount, String date) {
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("description", description);
        content.put("category", category);
        content.put("amount", amount);
        content.put("date", date);
        long result = db.insert(Database.TABLE_TRANSACTIONS, null, content);
        db.close();
        if ( result == -1 )
            return false;
        else
            return true;
    }
}