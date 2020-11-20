package com.example.budgetappfinal.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.budgetappfinal.model.Budget;

import java.util.ArrayList;

public class BudgetDao {
    private Database database;

    public BudgetDao(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        database = new Database(context,null,null,1);
    }
    public ArrayList<Budget> selectBudget() {
        ArrayList<Budget> budget = new ArrayList<>();
        SQLiteDatabase db = database.getReadableDatabase();
        String sql = "select * from " + Database.TABLE_BUDGET + ";";
        Cursor result = db.rawQuery(sql, null);

        while ( result.moveToNext() ) {
            Budget bg = new Budget(result.getInt(1), result.getString(2) );
            budget.add(bg);
        }

        result.close();
        db.close();

        return budget;
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
