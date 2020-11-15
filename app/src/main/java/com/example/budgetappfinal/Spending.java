package com.example.budgetappfinal;

public class Spending {
    private int spendingCod;
    private String description, category;
    private float amount;
    private String actualDate;

    public Spending(int spendingCod, String description, float amount, String emissionDate, String category) {
        this.spendingCod = spendingCod;
        this.description = description;
        this.category = category;
        this.amount = amount;
        this.actualDate = actualDate;
    }
    
    public int getSpendingCod() {
        return spendingCod;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getAmount() {
        return amount;
    }

    public String getActualDate() {
        return actualDate;
    }
}
