package com.example.myapplication.machinecoding.wallet.java.services;

import com.example.myapplication.machinecoding.wallet.java.dao.IWalletDao;
import com.example.myapplication.machinecoding.wallet.java.models.Account;

import java.util.Map;
import java.util.TreeMap;

public class WalletService {
    IWalletDao walletDao;

    public WalletService(IWalletDao walletDao){
        this.walletDao = walletDao;
    }

    public void createWallet(String name, double amount) {
        int id = walletDao.createAccount(name, amount);
        System.out.println("Account created for user ABC with account number: " + id);
    }

    public void transact(int senderId, int receiverId, double amount) {
        Account sender = walletDao.getAccount(senderId);
        Account receiver = walletDao.getAccount(receiverId);
        if (sender == null || receiver == null) {
            System.out.println("Invalid sender/receiver id");
            return;
        }
        if (sender.getBalance() - amount < 0) {
            System.out.println("Insufficient balance to send");
            return;
        }
        sender.deductAmount(amount);
        sender.addTransaction(senderId, receiverId, amount, 0, System.currentTimeMillis());
        walletDao.updateAccount(senderId, sender);
        receiver.addAmount(amount);
        receiver.addTransaction(senderId, receiverId, amount, 0, System.currentTimeMillis());
        walletDao.updateAccount(receiverId, receiver);
        System.out.println("Transfer Successful");
    }

    public void getStatement(int accountNumber) {
        Account account = walletDao.getAccount(accountNumber);
        System.out.println("Summary for account number: " + accountNumber);
        System.out.println("Current Balance: " + account.getBalance());
        System.out.println("Your Transaction History: " + account.getTransactions().toString());
    }

    public void overviewInput() {
        TreeMap<Integer, Account> map = walletDao.getAccounts();

        for (Map.Entry<Integer, Account> entry : map.entrySet()) {
            int key = entry.getKey();
            Account value = entry.getValue();
            System.out.println("Balance for account number " + key + " is " + value.getBalance());
        }
    }


}
