package com.example.budgetappfinal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.budgetappfinal.model.BudgetAnalysis;

import java.util.List;

public class AnalysisListviewAdapter extends ArrayAdapter<BudgetAnalysis> {

    private int layoutResource;

    public AnalysisListviewAdapter(Context context, int layoutResource, List<BudgetAnalysis> budgetAnalysisList) {
        super(context, layoutResource, budgetAnalysisList);
        this.layoutResource = layoutResource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(layoutResource, null);
        }

        BudgetAnalysis budgetAnalysis = getItem(position);
        ProgressBar itemProgressBar = (ProgressBar) view.findViewById(R.id.progressBar2);
        itemProgressBar.setMax(100);
        itemProgressBar.setProgress((int) (100-(budgetAnalysis.getProgress()*100)));
        itemProgressBar.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#028E08")));

        if (budgetAnalysis != null) {
            TextView title = (TextView) view.findViewById(R.id.textView1);
            TextView content1 = (TextView) view.findViewById(R.id.textView2);
            TextView content2 = (TextView) view.findViewById(R.id.textView3);

            if (title != null) {
                title.setText("Budget for "+budgetAnalysis.getBudgetCategory()+": $"+budgetAnalysis.getBudgetAmount());
            }
            if (content1 != null) {
                content1.setText("You have spent: $"+(Double)budgetAnalysis.getAmountSpent());
            }
            if (content2 != null) {
                content2.setText("You have $"+(Double)budgetAnalysis.getBudgetBalance()+" left to spend");
            }
        }

        return view;
    }
}