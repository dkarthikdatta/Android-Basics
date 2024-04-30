package com.example.myapplication.machinecoding.wallet.kotlin.services

import com.example.myapplication.machinecoding.wallet.java.dao.IWalletDao


class WalletService {
    var walletDao: IWalletDao? = null

    fun WalletService(walletDao: IWalletDao?) {
        this.walletDao = walletDao
    }

    fun createWallet(name: String?, amount: Double) {
        val id = walletDao!!.createAccount(name, amount)
        println("Account created for user ABC with account number: $id")
    }

    fun transact(senderId: Int, receiverId: Int, amount: Double) {
        val sender = walletDao!!.getAccount(senderId)
        val receiver = walletDao!!.getAccount(receiverId)
        if (sender == null || receiver == null) {
            println("Invalid sender/receiver id")
            return
        }
        if (sender.balance - amount < 0) {
            println("Insufficient balance to send")
            return
        }
        sender.deductAmount(amount)
        sender.addTransaction(senderId, receiverId, amount, 0, System.currentTimeMillis())
        walletDao!!.updateAccount(senderId, sender)
        receiver.addAmount(amount)
        receiver.addTransaction(senderId, receiverId, amount, 0, System.currentTimeMillis())
        walletDao!!.updateAccount(receiverId, receiver)
        println("Transfer Successful")
    }

    fun getStatement(accountNumber: Int) {
        val account = walletDao!!.getAccount(accountNumber)
        println("Summary for account number: $accountNumber")
        println("Current Balance: " + account.balance)
        println("Your Transaction History: " + account.transactions.toString())
    }

    fun overviewInput() {
        val map = walletDao!!.accounts
        for ((key, value) in map) {
            println("Balance for account number " + key + " is " + value.balance)
        }
    }
}