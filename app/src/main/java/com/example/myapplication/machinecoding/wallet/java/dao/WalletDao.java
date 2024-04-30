package com.example.myapplication.machinecoding.wallet.java.dao;

import com.example.myapplication.machinecoding.wallet.java.models.Account;
import com.example.myapplication.machinecoding.wallet.java.models.User;

import java.util.TreeMap;

public class WalletDao implements IWalletDao {
    TreeMap<Integer, Account> accounts = new TreeMap<>();

    public int createAccount(String name, double amount) {
        User user = new User(name);
        Account account = new Account(accounts.size() + 1, user, amount);
        accounts.put(account.getAccountNumber(), account);
        return account.getAccountNumber();
    }

    public TreeMap<Integer, Account> getAccounts() {
        return accounts;
    }

    public Account getAccount(int id) {
        if (accounts.containsKey(id)) {
            return accounts.get(id);
        }
        return null;
    }

    public void updateAccount(int id, Account user) {
        accounts.put(id, user);
    }

}
