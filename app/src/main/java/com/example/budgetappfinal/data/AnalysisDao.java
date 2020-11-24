package com.example.budgetappfinal.data;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.budgetappfinal.model.Budget;
import com.example.budgetappfinal.model.BudgetAnalysis;
import com.example.budgetappfinal.model.Transaction;

import java.util.ArrayList;

public class AnalysisDao {
    private static Database database;

    public AnalysisDao(Context context) {
        database = new Database(context);
    }

    public void insertBudgetForAnalysis(String category,int amount, double spent) {
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("category", category);
        content.put("goalAmount", amount);
        content.put("spentAmount", spent);
        db.insert(Database.TABLE_BUDGET_BALANCE, null, content);
        db.close();
    }
    public static boolean updateTransaction(BudgetAnalysis b) {
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues content = new ContentValues();
        //content.put("category", b.getBudgetCategory());
        //content.put("goalAmount", amount);
        content.put("spentAmount", b.getBudgetSpent());
        db.update(Database.TABLE_BUDGET_BALANCE, content, "category = ? ", new String[] {b.getBudgetCategory()} );
        return true;
    }
    public static BudgetAnalysis selectBudget(String category) {
        SQLiteDatabase db = database.getReadableDatabase();
        String sql = "select * from " + Database.TABLE_BUDGET_BALANCE + " where category = '" + category + "';";
        Cursor result = db.rawQuery(sql, null);
        result.moveToFirst();
        BudgetAnalysis b = new BudgetAnalysis( result.getString(1),result.getInt(2), result.getDouble(3));
        result.close();
        db.close();

        return b;
    }
}