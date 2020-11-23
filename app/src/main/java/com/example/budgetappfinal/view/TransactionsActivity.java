package com.example.budgetappfinal.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.Toast;

import com.example.budgetappfinal.R;
import com.example.budgetappfinal.data.Database;
import com.example.budgetappfinal.presenter.BudgetActivityPresenter;
import com.example.budgetappfinal.presenter.TransactionsInterface;
import com.example.budgetappfinal.presenter.TransactionsPresenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TransactionsActivity extends AppCompatActivity implements TransactionsInterface {
    private EditText description, amount, dateRecorded;
    private Spinner spCategory;
    private Button btnClear, btnSubmit;
    private Date date;
    private TransactionsPresenter tPresenter;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);

        database = new Database(this);
        tPresenter = new TransactionsPresenter(this, this.getApplicationContext() );

        description = (EditText) findViewById(R.id.editTextDescription);
        amount =(EditText)  findViewById(R.id.editTextAmount);
        dateRecorded = (EditText) findViewById(R.id.editTextDate);
        spCategory = (Spinner) findViewById(R.id.spCategory);
        btnClear = findViewById(R.id.btnClear);
        btnSubmit = findViewById(R.id.btnSubmit);




        CategorySpinner();

        date = new Date(System.currentTimeMillis());
        SimpleDateFormat Dt = new SimpleDateFormat("MM/DD/YYYY");
        dateRecorded.setText(Dt.format(date));
        dateRecorded.setEnabled(true);


        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( tPresenter.insertTransaction() ) {
                    finish();
                }
            }
        });
    }
        public void clear() {
            description.requestFocus();
            description.setText(null);
            amount.setText(null);
            dateRecorded.setText(null);
            spCategory.setSelection(0);
        }
        public void CategorySpinner() {
            final String[] Category = {
                    this.getResources().getString(R.string.bills),
                    this.getResources().getString(R.string.education),
                    this.getResources().getString(R.string.entertainment),
                    this.getResources().getString(R.string.food_dining),
                    this.getResources().getString(R.string.health_fitness),
                    this.getResources().getString(R.string.other),
                    this.getResources().getString(R.string.personal_care),
                    this.getResources().getString(R.string.shopping),
                    this.getResources().getString(R.string.transportation),
                    this.getResources().getString(R.string.travel)
            };
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, Category);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spCategory.setAdapter(adapter);
        }
    @Override
    public String getTransDescription() {
        return description.getText().toString();
    }
    @Override
    public String getTransAmount() {
        return amount.getText().toString();
    }
    @Override
    public String getTransActualDate() {
        return dateRecorded.getText().toString();
    }
    @Override
    public String getTransCategory() {
        return spCategory.getSelectedItem().toString();
    }

    @Override
    public void successInserted() {
        Toast.makeText(TransactionsActivity.this, getResources().getString(R.string.successfully_inserted), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void dbInsertError() {
        Toast.makeText(TransactionsActivity.this, getResources().getString(R.string.db_insert_error), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void registrationError() {
        //Toast.makeText(TransactionsActivity.this, getResources().getString(R.string.db_insert_error), Toast.LENGTH_SHORT).show();
    }
}
