package com.example.budgetappfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class BudgetActivity extends AppCompatActivity implements BudgetInterface {
    private EditText etAmount;
    private Spinner spCategory;
    private Button btnClear, btnSave;
    private BudgetActivityPresenter bPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

        etAmount = (EditText) findViewById(R.id.edtAmount);
        spCategory = (Spinner) findViewById(R.id.spnCategory);
        bPresenter = new BudgetActivityPresenter(this, this.getApplicationContext() );
        //addCategorySpinner();
       /* btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // clean();
            }
        });

        /*btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( bPresenter.budgetRegistration() )
                    finish();
            }
        });*/
    }

    public void addCategorySpinner() {
        final String[] arrayCategory = {
                this.getResources().getString(R.string.transport),
                this.getResources().getString(R.string.bills),
                this.getResources().getString(R.string.education),
                this.getResources().getString(R.string.entertainment),
                this.getResources().getString(R.string.food_dining),
                this.getResources().getString(R.string.health_fitness),
                this.getResources().getString(R.string.other),
                this.getResources().getString(R.string.personal_care),
                this.getResources().getString(R.string.shopping),
                this.getResources().getString(R.string.travel)
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayCategory);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCategory.setAdapter(adapter);
    }
    public void clean() {

        etAmount.setText(null);

        spCategory.setSelection(0);

    }

    @Override
    public String getbudgetAmount() {
        return null;
    }

    @Override
    public String getbudgetCategory() {
        return null;
    }

    @Override
    public void inserted() {

    }
    @Override
    public void databaseInsertError(){

    }
    @Override
    public void registrationError(){

    }

}