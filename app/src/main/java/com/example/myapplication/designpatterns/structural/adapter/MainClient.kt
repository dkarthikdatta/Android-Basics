package com.example.myapplication.designpatterns.structural.adapter

class MainClient {
    fun test() {
        val adapter: SocketAdapter = SocketAdapterImpl()
        val volt30 = adapter.get30Volts()
        println(volt30)
    }
}