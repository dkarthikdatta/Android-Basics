package com.example.myapplication.machinecoding.splitwise.dao;

import com.example.myapplication.machinecoding.splitwise.models.Account;

import java.util.HashMap;

public interface IDao {
    void createAccount(Integer accountId, Account account);
    HashMap<Integer, Account> getAccounts();
    void updateBalance(int accountId, double balance);

    Account getPayeeAccountDetails(int payeeUserId);

    Account getAccount(int key);
}
