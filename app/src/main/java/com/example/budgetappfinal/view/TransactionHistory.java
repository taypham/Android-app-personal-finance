package com.example.budgetappfinal.view;

import androidx.appcompat.app.AppCompatActivity;
import com.example.budgetappfinal.R;
import com.example.budgetappfinal.data.BudgetDao;
import com.example.budgetappfinal.data.TransactionDao;
import com.example.budgetappfinal.model.Transaction;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TransactionHistory extends AppCompatActivity {
    TransactionDao tDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);
        tDao = new TransactionDao(this);

        printTransactionList();


    }

    public void printTransactionList(){
        ArrayList<String> transArray= new ArrayList<>();


        transArray = tDao.getAllTransaction();

        String [] arrayBtoString = new String[transArray.size()];
        int i = 0;

        for (Object value : transArray){
            arrayBtoString[i] = (String) value;
            i++;
        }

        ListAdapter bgListAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayBtoString);
        ListView foodsListView = (ListView) findViewById(R.id.lvTransaction);
        foodsListView.setAdapter(bgListAdapter);
    }
}