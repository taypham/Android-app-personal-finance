package com.example.budgetappfinal;

public interface TransactionsInterface {
    String getDescription();
    String getAmount();
    String getActualDate();
    String getCategory();
    void successInserted();
    void dbInsertError();
}
