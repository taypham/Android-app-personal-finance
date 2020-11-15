package com.example.budgetappfinal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.ArrayList;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;


public class TransactionsActivity extends AppCompatActivity implements TransactionsInterface {
    private EditText description, amount, actualDate;
    private Spinner spCategory;
    private Button btnClear, btnSubmit;
    private Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);

        description = findViewById(R.id.editTextDescription);
        amount = findViewById(R.id.editTextAmount);
        actualDate = findViewById(R.id.editTextDate);
        spCategory = findViewById(R.id.spCategory);
        btnClear = findViewById(R.id.btnClear);
        btnSubmit = findViewById(R.id.btnSubmit);

        CategorySpinner();

        date = new Date(System.currentTimeMillis());
        SimpleDateFormat Dt = new SimpleDateFormat("DD/MM/YYYY");
        actualDate.setText(Dt.format(date));
        actualDate.setEnabled(false);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });

        /*btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (Transaction())
                  finish();
            }
        });*/
    }
        public void clear() {
            description.requestFocus();
            description.setText(null);
            amount.setText(null);
            actualDate.setText(null);
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

    public String getDescription() {
        return description.getText().toString();
    }
    public String getAmount() {
        return amount.getText().toString();
    }
    public String getActualDate() {
        return actualDate.getText().toString();
    }
    public String getCategory() {
        return spCategory.getSelectedItem().toString();
    }

    public void successInserted() {
        Toast.makeText(TransactionsActivity.this, getResources().getString(R.string.successfully_inserted), Toast.LENGTH_SHORT).show();
    }
    public void dbInsertError() {
        Toast.makeText(TransactionsActivity.this, getResources().getString(R.string.db_insert_error), Toast.LENGTH_SHORT).show();
    }
}
