package com.example.myapplication.machinecoding.wallet.java.models;

import java.util.ArrayList;

public class Account {
    int accountNumber;
    User user;

    double balance;
    ArrayList<Transaction> transactions;

    public Account(int accountNumber, User user, double balance){
        this.accountNumber = accountNumber;
        this.user = user;
        this.balance = balance;
        transactions = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void updateBalance(double balance) {
        this.balance = balance;
    }

    public boolean deductAmount(double amount) {
        if (this.balance > amount) {
            this.balance = this.balance - amount;
            return true;
        }
        return false;
    }

    public void addAmount(double amount) {
        this.balance = this.balance + amount;
    }

    public void addTransaction(){

    }

    public void addTransaction(int senderId, int receiverId, double amount, long transactionId, long timeStamp) {
        Transaction transaction = new Transaction(senderId, receiverId, amount, transactionId, timeStamp);
        transactions.add(transaction);
    }

    public ArrayList<Transaction> getTransactions(){
        return transactions;
    }

}
