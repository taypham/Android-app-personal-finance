package com.example.budgetappfinal.model;

public class Balance {
    private Double balance;
    private Double income;

    public Balance(double balance, double income) {
        this.balance = balance;
        this.income = income;

    }


    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getIncome() {
        return income;
    }
    public void setIncome(double income) {
        this.income = income;
    }



}

