package com.example.budgetappfinal.model;
public class BudgetAnalysis {
    private int budgetAmount;
    private String budgetCategory;
    private Double budgetSpent;


    public BudgetAnalysis( String budgetCategory, int budgetAmount,Double budgetSpent) {
        this.budgetAmount = budgetAmount;
        this.budgetCategory = budgetCategory;
        this.budgetSpent = budgetSpent;
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
    public void setBudgetSpent(Double budgetSpent) {
        this.budgetSpent = budgetSpent;
    }

    public double getBudgetSpent() {
        return budgetSpent;
    }
}