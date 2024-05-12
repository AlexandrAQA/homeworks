package org.sqlLite.model;

public class Account {

    private int accountId;
    private int userId;
    private double balance;
    private String currency;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Account(int accountId, int userId, double balance, String currency) {
        this.accountId = accountId;
        this.userId = userId;
        this.balance = balance;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return accountId + " | " + userId + " | " + balance + " | " + currency;
    }
}
