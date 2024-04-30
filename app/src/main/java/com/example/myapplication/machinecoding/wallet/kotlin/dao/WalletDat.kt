package com.example.myapplication.machinecoding.wallet.kotlin.dao

import com.example.myapplication.machinecoding.wallet.java.dao.IWalletDao
import com.example.myapplication.machinecoding.wallet.java.models.Account
import com.example.myapplication.machinecoding.wallet.java.models.User
import java.util.TreeMap


class WalletDao : IWalletDao {
    private var accounts = TreeMap<Int, Account>()
    override fun createAccount(name: String, amount: Double): Int {
        val user = User(name)
        val account = Account(accounts.size + 1, user, amount)
        accounts[account.accountNumber] = account
        return account.accountNumber
    }

    override fun getAccounts(): TreeMap<Int, Account> {
        return accounts
    }

    override fun getAccount(id: Int): Account? {
        return if (accounts.containsKey(id)) {
            accounts[id]!!
        } else null
    }

    override fun updateAccount(id: Int, user: Account) {
        accounts[id] = user
    }
}
