package com.example.budgetappfinal.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.budgetappfinal.model.Budget;

import java.util.ArrayList;

public class BudgetDao {
    private static Database database;

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
    // Return Budget table out as a string array
    public ArrayList<String> getAllBudget() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from budget",null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex("category"))+": $"+
                    res.getString(res.getColumnIndex("amount")));
            res.moveToNext();
        }
        return array_list;
    }
    public static ArrayList<String> getAllBudgetCategory() {
        ArrayList<String> array_list = new ArrayList<String>();
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from budget",null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex("category")));
            res.moveToNext();
        }
        return array_list;
    }
    //Delete a budget
    public void deleteBudget(String budgetName){
        SQLiteDatabase db = database.getWritableDatabase();
        db.execSQL("DELETE FROM " + database.TABLE_BUDGET + " WHERE category =\"" + budgetName + "\";");
        db.execSQL("DELETE FROM " + database.TABLE_BUDGET_ANALYSIS + " WHERE category =\"" + budgetName + "\";");
    }
}
