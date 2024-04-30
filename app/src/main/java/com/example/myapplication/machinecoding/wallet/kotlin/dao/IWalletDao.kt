package com.example.myapplication.machinecoding.wallet.kotlin.dao

import com.example.myapplication.machinecoding.wallet.kotlin.models.Account
import java.util.TreeMap;


interface IWalletDao {
    fun createAccount(name: String?, amount: Double): Int
    val accounts: TreeMap<Int?, Account?>?

    fun getAccount(id: Int): Account?
    fun updateAccount(id: Int, user: Account?)
}

