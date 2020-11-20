package com.example.budgetappfinal.presenter;

public interface BudgetInterface {
    String getBudgetAmount();
    String getBudgetCategory();

    void inserted();

    void databaseInsertError();

    void registrationError();
}
