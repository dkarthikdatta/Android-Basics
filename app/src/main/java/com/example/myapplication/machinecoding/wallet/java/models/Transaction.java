package com.example.myapplication.machinecoding.wallet.java.models;

import java.util.Date;

public class Transaction {
    int fromId;
    int toId;
    double amount;
    long transactionId;
    long timeStamp;

    public Transaction(int senderId, int receiverId, double amount, long transactionId, long timeStamp) {
        this.fromId = senderId;
        this.toId = receiverId;
        this.amount = amount;
        this.transactionId = transactionId;
        this.timeStamp = timeStamp;
    }
}
