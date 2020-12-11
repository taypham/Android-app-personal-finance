package com.example.budgetappfinal.data;
import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.budgetappfinal.model.Balance;
import com.example.budgetappfinal.model.BudgetAnalysis;

public class BalanceDao {


    private static Database database;


    public BalanceDao(Context context) {
        database = new Database(context);
    }



    public void insertIncome(double balance, double addIncome) {
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("balance", balance);
        content.put("income", addIncome);
        db.insert(Database.TABLE_BALANCE, null, content);
        db.close();
    }
    public static boolean updateAfterTransaction(Balance b) {
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("balance", b.getBalance());
        content.put("income", b.getIncome());
        db.update(Database.TABLE_BALANCE, content, "id = ?", new String[] {"1"} );
        return true;
    }
    public static Balance requestBalance() {
        SQLiteDatabase db = database.getReadableDatabase();
        int id =1;
        String sql = "select * from " + Database.TABLE_BALANCE + " where id = '" + id + "';";
        Cursor result = db.rawQuery(sql, null);
        result.moveToFirst();
        Balance b = new Balance( result.getDouble(1), result.getDouble(2));
        result.close();
        db.close();
        return b;
    }

}
