package com.example.budgetappfinal.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.budgetappfinal.data.Database;
import com.example.budgetappfinal.presenter.BudgetActivityPresenter;
import com.example.budgetappfinal.R;
import com.example.budgetappfinal.data.BudgetDao;
import com.example.budgetappfinal.model.Budget;
import com.example.budgetappfinal.presenter.BudgetInterface;

import java.util.ArrayList;

public class BudgetActivity extends AppCompatActivity implements BudgetInterface {
    private static final String TAG = BudgetActivity.class.getSimpleName();
    private EditText etAmount;
    private Spinner spCategory;
    private Button btnClear, btnSave,btnDelete;
    private BudgetActivityPresenter bPresenter;
    private BudgetDao bDao;
    Database db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        db = new Database(this);

        etAmount = (EditText) findViewById(R.id.edtAmount);
        spCategory = (Spinner) findViewById(R.id.spCategoryB);
        bPresenter = new BudgetActivityPresenter(this, this.getApplicationContext() );
        CategorySpinner();

        btnClear = findViewById(R.id.btnClear);
        btnSave = findViewById(R.id.btnSave);
        btnDelete = findViewById(R.id.btnDelete);

        printBudgetList();


        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etAmount.setText(null);
                spCategory.setSelection(0);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteButtonClicked(v);
                printBudgetList();
            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( bPresenter.insertBudget() ) {
                    Log.d(TAG, "after clicked btn save");
                    //finish();
                    printBudgetList();

                }
            }
        });
    }
    public void printBudgetList(){
        ArrayList<String> budgetArray= new ArrayList<>();

        budgetArray = db.getAllBudget();

        String [] arrayBtoString = new String[budgetArray.size()];
        int i = 0;

        for (Object value : budgetArray){
            arrayBtoString[i] = (String) value;
            i++;
        }

        ListAdapter bgListAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayBtoString);
        ListView foodsListView = (ListView) findViewById(R.id.bgListView);
        foodsListView.setAdapter(bgListAdapter);
    }

    public void deleteButtonClicked(View view){
        String inputText = spCategory.getSelectedItem().toString();
        db.deleteBudget(inputText);
        //printDatabase();
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
    public String getBudgetAmount() {
        return etAmount.getText().toString();
    }

    @Override
    public String getBudgetCategory() {
        return spCategory.getSelectedItem().toString();
    }

    @Override
    public void inserted() {
        Toast.makeText(BudgetActivity.this, getResources().getString(R.string.successfully_inserted), Toast.LENGTH_SHORT).show();

    }
    @Override
    public void databaseInsertError(){
        Toast.makeText(BudgetActivity.this, getResources().getString(R.string.db_insert_error), Toast.LENGTH_SHORT).show();

    }
    @Override
    public void registrationError(){
    }

}