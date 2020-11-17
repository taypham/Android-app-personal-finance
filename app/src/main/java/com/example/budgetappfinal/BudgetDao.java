package com.example.budgetappfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.example.budgetappfinal.Database;

public class BudgetDao {
    private Database database;

    public BudgetDao(Context c) {
    }

    public boolean insertBudget(Float amount, String category) {
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
