package com.example.myapplication.machinecoding.wallet.kotlin.models

class Transaction(
    var fromId: Int,
    var toId: Int,
    var amount: Double,
    var transactionId: Long,
    var timeStamp: Long
)
