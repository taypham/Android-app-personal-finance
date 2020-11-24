package com.example.budgetappfinal.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.budgetappfinal.R;
import com.example.budgetappfinal.data.AnalysisDao;
import com.example.budgetappfinal.data.TransactionDao;

import java.util.ArrayList;

public class AnalysisActivity extends AppCompatActivity {
    AnalysisDao aDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);

        aDao = new AnalysisDao(this);

        printAnalysisList();

    }
    public void printAnalysisList(){
        ArrayList<String> analysisArray= new ArrayList<>();


        analysisArray = aDao.getAllBudgets();

        String [] arrayBtoString = new String[analysisArray.size()];
        int i = 0;

        for (Object value : analysisArray){
            arrayBtoString[i] = (String) value;
            i++;
        }

        ListAdapter bgListAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayBtoString);
        ListView foodsListView = (ListView) findViewById(R.id.lvAnalysis);
        foodsListView.setAdapter(bgListAdapter);
    }
}