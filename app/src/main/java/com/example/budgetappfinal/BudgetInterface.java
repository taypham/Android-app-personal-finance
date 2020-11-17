package com.example.budgetappfinal;

public interface BudgetInterface {
    String getbudgetAmount();
    String getbudgetCategory();

    void inserted();

    void databaseInsertError();

    void registrationError();
}
