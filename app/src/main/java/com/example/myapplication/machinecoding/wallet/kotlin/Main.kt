package com.example.myapplication.machinecoding.wallet.kotlin

import com.example.myapplication.machinecoding.wallet.java.dao.IWalletDao
import com.example.myapplication.machinecoding.wallet.java.dao.WalletDao
import com.example.myapplication.machinecoding.wallet.java.services.WalletService
import java.util.Scanner


object Main {
    var scanner = Scanner(System.`in`)
    var walletService: WalletService? = null
    @JvmStatic
    fun main(args: Array<String>) {
        val walletDao: IWalletDao = WalletDao()
        walletService = WalletService(walletDao)
        var input = 0
        while (input != 5) {
            showOptions()
            input = scanner.nextInt()
            validateAndRun(input)
        }
        println("Exited from System")
    }

    private fun validateAndRun(input: Int) {
        when (input) {
            1 -> createWalletInput()
            2 -> transferAmountInput()
            3 -> statementInput()
            4 -> walletService!!.overviewInput()
        }
    }

    private fun statementInput() {
        println("YOU SELECTED ACCOUNT STATEMENT")
        println("Enter account num")
        val accountNumber = scanner.nextInt()
        walletService!!.getStatement(accountNumber)
    }

    private fun transferAmountInput() {
        println("YOU SELECTED TRANSFER")
        println("Enter SENDER account number")
        val senderId = scanner.nextInt()
        println("Enter RECEIVER account number")
        val receiverId = scanner.nextInt()
        println("Enter amount")
        val amount = scanner.nextDouble()
        walletService!!.transact(senderId, receiverId, amount)
    }

    private fun createWalletInput() {
        println("YOU SELECTED CREATE WALLET")
        println("Enter name")
        val name = scanner.next()
        println("Enter amount")
        val amount = scanner.nextDouble()
        walletService!!.createWallet(name, amount)
    }

    private fun showOptions() {
        println("Select anyone")
        println(
            """
                1. Create wallet
                2. Transfer Amount
                3. Account Statement
                4. Overview
                5. Exit
                """.trimIndent()
        )
    }
}

