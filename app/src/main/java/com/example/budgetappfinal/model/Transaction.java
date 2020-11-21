package com.example.budgetappfinal.model;

public class Transaction {
    private int id;
    private String description, category;
    private float amount;
    private String dateRecorded;

    public Transaction( String description,String category, float amount, String date) {

        this.description = description;
        this.category = category;
        this.amount = amount;
        this.dateRecorded = date;
    }
    
    public int getTransaction_Id() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public float getAmount() {
        return amount;
    }

    public String getActualDate() {
        return dateRecorded;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTransaction_Id() {
        this.id = id;
    }

    public void setDescription() {
        this.description = description;
    }


    public void setAmount() {
        this.amount = amount;
    }

    public void setActualDate() {
        this.dateRecorded = dateRecorded;
    }

}
