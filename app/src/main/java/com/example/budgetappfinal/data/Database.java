package com.example.budgetappfinal.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.budgetappfinal.model.Budget;

import org.json.JSONException;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1 ;
    public static final String DATABASE_NAME = "myBudget.db";
    public static final String TABLE_BUDGET = "budget";
    public static final String TABLE_TRANSACTIONS = "transactions";


    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_BUDGET +
                "(budgetCod integer primary key autoincrement," +
                "amount real not null, " +
                "category text not null); "
        );
        db.execSQL("create table " + TABLE_TRANSACTIONS +
                "(transId integer primary key autoincrement, " +
                "description text not null, " +
                "category text not null, " +
                "amount real not null, " +
                "date text not null); "
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_BUDGET);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_TRANSACTIONS);
        onCreate(db);
    }

    //Delete a budget
    public void deleteBudget(String budgetName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_BUDGET + " WHERE category =\"" + budgetName + "\";");
    }

    // Return Budget table out as a string array
    public ArrayList<String> getAllBudget() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from budget",null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex("category"))+": "+ res.getString(res.getColumnIndex("amount")));
            res.moveToNext();
        }
        return array_list;
    }


    public boolean insertTransaction(String description, String category, Float amount, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("description", description);
        contentValues.put("category", category);
        contentValues.put("amount", amount);
        contentValues.put("date", date);
        long result = db.insert(TABLE_TRANSACTIONS, null, contentValues);
        db.close();
        return true;
    }




}
