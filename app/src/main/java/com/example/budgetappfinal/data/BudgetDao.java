package com.example.budgetappfinal.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.budgetappfinal.model.Budget;

import java.util.ArrayList;

public class BudgetDao {
    private Database database;

    public BudgetDao(Context context) {
        database = new Database(context);
    }

    public boolean insertBudget(int amount, String category) {
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("amount", amount);
        content.put("category", category);
        long result = db.insert(Database.TABLE_BUDGET, null, content);
        db.close();
        if ( result == -1 )
            return false;
        else
            return true;
    }
}
