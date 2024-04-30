package com.example.myapplication.machinecoding.wallet.java.dao;

import com.example.myapplication.machinecoding.wallet.java.models.Account;

import java.util.TreeMap;

public interface IWalletDao {
    int createAccount(String name, double amount);

    TreeMap<Integer, Account> getAccounts();

    Account getAccount(int id);

    void updateAccount(int id, Account user);
}
