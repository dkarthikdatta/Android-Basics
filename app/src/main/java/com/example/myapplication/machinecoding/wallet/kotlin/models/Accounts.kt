package com.example.myapplication.machinecoding.wallet.kotlin.models

import com.example.myapplication.machinecoding.wallet.java.models.Transaction
import com.example.myapplication.machinecoding.wallet.java.models.User

class Account(var accountNumber: Int, var user: User, var balance: Double) {
    private var transactions: ArrayList<Transaction> = ArrayList()

    fun updateBalance(balance: Double) {
        this.balance = balance
    }

    fun deductAmount(amount: Double): Boolean {
        if (balance > amount) {
            balance = balance - amount
            return true
        }
        return false
    }

    fun addAmount(amount: Double) {
        balance = balance + amount
    }

    fun addTransaction() {}
    fun addTransaction(
        senderId: Int,
        receiverId: Int,
        amount: Double,
        transactionId: Long,
        timeStamp: Long
    ) {
        val transaction = Transaction(senderId, receiverId, amount, transactionId, timeStamp)
        transactions.add(transaction)
    }
}
