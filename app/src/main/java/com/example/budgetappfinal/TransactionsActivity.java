package com.example.budgetappfinal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
import wallyson.com.br.mypocket.presenter.SpendingActivityPresenter;
import wallyson.com.br.mypocket.presenter.SpendingInterface;*/

public class TransactionsActivity extends AppCompatActivity {
    private EditText description, amount, actualDate;
    private Spinner spCategory;
    private Button btnClear, btnSubmit;
    private Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);

        description = (EditText) findViewById(R.id.edtBalance);
        amount = (EditText) findViewById(R.id.editTextAmount);
        actualDate = (EditText) findViewById(R.id.editTextDate);
        spCategory = (Spinner) findViewById(R.id.spCategory);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        date = new Date(System.currentTimeMillis());
        SimpleDateFormat Dt = new SimpleDateFormat("DD/MM/YYYY");
        actualDate.setText(Dt.format(date));
        actualDate.setEnabled(false);

        /*btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clean();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( mPresenter.spendingRegistration() )
                    finish();
            }
        });

        public void clear() {
            description.requestFocus();
            description.setText(null);
            amount.setText(null);
            actualDate.setText(null);
            spCategory.setSelection(0);
        }
        public void CategorySpinner() {
            final String[] Category = {


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

        public String getEmissionDate() {
            return actualDate.getText().toString();
        }

        public String getCategory() {
            return spCategory.getSelectedItem().toString();
        }
        public void successfullyInserted() {
            Toast.makeText(SpendingActivity.this, getResources().getString(R.string.successfully_registration), Toast.LENGTH_SHORT).show();
        }

        public void databaseInsertError() {
            Toast.makeText(SpendingActivity.this, getResources().getString(R.string.database_insert_error), Toast.LENGTH_SHORT).show();
        }

        public void registrationError() {
            Toast.makeText(SpendingActivity.this, getResources().getString(R.string.registration_error), Toast.LENGTH_SHORT).show();
        }*/
    }
}
