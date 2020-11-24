package com.example.budgetappfinal.model;
public class BudgetAnalysis {
    private int budgetAmount;
    private String budgetCategory;
    private Double amountSpent;
    private Double balanceAmount;
    private Double progress;


    public BudgetAnalysis( String budgetCategory, int budgetAmount,Double amountSpent, Double balance, Double progress) {
        this.budgetAmount = budgetAmount;
        this.budgetCategory = budgetCategory;
        this.amountSpent = amountSpent;
        this.balanceAmount = balance;
        this.progress = progress;
    }


    public String getBudgetCategory() {
        return budgetCategory;
    }
    public void setBudgetCategory(String budgetCategory) {
        this.budgetCategory = budgetCategory;
    }


    public void setBudgetAmount(int budgetAmount) {
        this.budgetAmount = budgetAmount;
    }
    public int getBudgetAmount() {
        return budgetAmount;
    }

    public void setAmountSpent(Double amountSpent) {
        this.amountSpent = amountSpent;
    }
    public double getAmountSpent() {
        return amountSpent;
    }

    public void setBudgetBalance(Double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }
    public double getBudgetBalance() {
        return balanceAmount;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }
    public double getProgress() {
        return progress;
    }
}