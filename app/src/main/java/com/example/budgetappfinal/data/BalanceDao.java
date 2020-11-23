package com.example.budgetappfinal.data;
import android.content.ContentValues;
import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
public class BalanceDao {
    private Database database;

    public BalanceDao(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        database = new Database(context,null,null,1);
    }

    public boolean insertBalance(float balance, float addIncome, float income) {
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("balance", balance);
        content.put("addIncome", addIncome);
        content.put("income", income);
        long result = db.insert(Database.TABLE_BALANCE, null, content);
        db.close();
        if ( result == -1 )
            return false;
        else
            return true;
    }
}
