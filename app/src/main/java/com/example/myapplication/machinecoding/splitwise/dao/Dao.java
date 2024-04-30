package com.example.myapplication.machinecoding.splitwise.dao;

import com.example.myapplication.machinecoding.splitwise.models.Account;

import java.util.HashMap;

public class Dao implements IDao {
    // accountId, account
    HashMap<Integer, Account> accounts = new HashMap<>();


    @Override
    public void createAccount(Integer accountId, Account account) {
        accounts.put(accountId, account);
    }

    public HashMap<Integer, Account> getAccounts() {
        return accounts;
    }

    @Override
    public void updateBalance(int accountId, double balance) {

    }

    @Override
    public Account getPayeeAccountDetails(int payeeUserId) {
        if (accounts.containsKey(payeeUserId)) {
            return accounts.get(payeeUserId);
        }
        return null;
    }

    @Override
    public Account getAccount(int key) {
        if (accounts.containsKey(key)) {
            return accounts.get(key);
        }
        return null;
    }
}
