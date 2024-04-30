package com.example.myapplication.machinecoding.splitwise.models;

import java.util.HashMap;

public class Account {

    User user;


    int accountId;


    // otherUserId, balances
    HashMap<Integer, Double> balances;

    public Account(User user) {
        this.user = user;
        this.accountId = user.getUserId();
        balances = new HashMap<>();
    }

    public HashMap<Integer, Double> getBalances() {
        return balances;
    }

    public void updateBalance(int accountId, double amount) {
        balances.put(accountId, amount);
    }

    public int getAccountId() {
        return accountId;
    }

    public User getUser() {
        return user;
    }
}
