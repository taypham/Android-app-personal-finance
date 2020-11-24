package com.example.budgetappfinal.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.budgetappfinal.model.Budget;
import com.example.budgetappfinal.data.Database;
import com.example.budgetappfinal.model.Transaction;

import java.util.ArrayList;

public class TransactionDao {
    private Database database;

    public TransactionDao(Context context) {
        database = new Database(context);
    }

    public boolean insertTransaction(String description, String category, Double amount, String date) {
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
    // Return Budget table out as a string array
    public ArrayList<String> getAllTransaction() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from transactions",null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add("Transaction Amount: $"+res.getString(res.getColumnIndex("amount")) + "\n"+
                    "Description: "+res.getString(res.getColumnIndex("description"))+"\n"+
                    "Category: "+res.getString(res.getColumnIndex("category"))+"\n"+
                    "Date purchased: "+ res.getString(res.getColumnIndex("date")));
            res.moveToNext();
        }
        return array_list;
    }
    //Update Balance send a call to balance table and update it.
    public void updateBalance(){}


}