package com.example.arcomputers.expansemanager;

public class Expense {
    private String name;
    private long unixDateTime;
    private int id, category;
    private double amount;

    public Expense(int id, String name, int category, double amount, long unixDateTime) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.unixDateTime = unixDateTime;
        this.amount = amount;
    }

    public Expense(String name, int category, long unixDateTime, double amount) {
        this.name = name;
        this.category = category;
        this.unixDateTime = unixDateTime;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public long getUnixDateTime() {
        return unixDateTime;
    }

    public void setUnixDateTime(long unixDateTime) {
        this.unixDateTime = unixDateTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
