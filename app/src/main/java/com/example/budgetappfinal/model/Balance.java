package com.example.budgetappfinal.model;

public class Balance {
    private float addIncome;
    private float balance;
    private float income;

    public Balance(float addIncome, float balance, float income) {
        this.addIncome = addIncome;
        this.balance = balance;
        this.income = income;

    }

    public float getAddIncome() {
        return addIncome;
    }
    public void setAddIncome(float addIncome) {
        this.addIncome = addIncome;
    }

    public float getBalance() {
        return balance;
    }
    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getIncome() {
        return income;
    }
    public void setIncome(float income) {
        this.income = income;
    }



}

