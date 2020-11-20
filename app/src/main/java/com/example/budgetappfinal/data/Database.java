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


    public static final String TABLE_BUDGET2 = "budget2";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_CATEGORY = "category2";
    public static final String COLUMN_AMOUNT = "amount2";

    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_BUDGET +
                "(budgetCod integer primary key autoincrement," +
                "amount real not null, " +
                "category text not null); " );
        String queryTest = "CREATE TABLE " +TABLE_BUDGET2+ "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
               /// COLUMN_AMOUNT +" real not null, " +
                COLUMN_CATEGORY +" TEXT not null"+ ");";
        db.execSQL(queryTest);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_BUDGET);
        onCreate(db);
    }

    //Add a budget
    public void addBudget(Budget budget){
        ContentValues values = new ContentValues();
       // values.put(COLUMN_AMOUNT,budget.getBudgetAmount());
        values.put(COLUMN_CATEGORY,budget.getBudgetCategory());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_BUDGET2,null,values);
        db.close();
    }

    //Delete a budget
    public void deleteBudget(String budgetName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_BUDGET + " WHERE category =\"" + budgetName + "\";");
    }

    // Print out as a string
    public String databaseToString(){
        String dbString ="";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_BUDGET + " WHERE 1";

        //Cursor point to reasult
        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("category"))!=null);
                dbString+= c.getString(c.getColumnIndex("category"));
                dbString += "\n";
        }
        db.close();
        return dbString;
    }


}
