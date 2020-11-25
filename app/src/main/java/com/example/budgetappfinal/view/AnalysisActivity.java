package com.example.budgetappfinal.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.budgetappfinal.AnalysisListviewAdapter;
import com.example.budgetappfinal.R;
import com.example.budgetappfinal.data.AnalysisDao;
import com.example.budgetappfinal.data.TransactionDao;
import com.example.budgetappfinal.model.BudgetAnalysis;

import java.util.ArrayList;
import java.util.List;

public class AnalysisActivity extends AppCompatActivity {
    AnalysisDao analysisDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);
        analysisDao = new AnalysisDao(this);

        ArrayList<BudgetAnalysis> budgetAnalysisList = new ArrayList<BudgetAnalysis>();

        budgetAnalysisList = analysisDao.getAllBudgetingData();

        ListView listView = (ListView) findViewById(R.id.lvAllBudgetsData);
        AnalysisListviewAdapter analysisListviewAdapter = new AnalysisListviewAdapter(this, R.layout.analysis_adapter_views_layout, budgetAnalysisList);
        listView.setAdapter(analysisListviewAdapter);

    }

}