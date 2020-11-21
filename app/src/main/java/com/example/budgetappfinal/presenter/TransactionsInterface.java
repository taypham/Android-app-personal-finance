package com.example.budgetappfinal.presenter;

public interface TransactionsInterface {
    String getTransDescription();
    String getTransAmount();
    String getTransActualDate();
    String getTransCategory();
    void successInserted();
    void dbInsertError();
    void registrationError();
}
