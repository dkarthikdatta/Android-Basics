package com.example.myapplication.designpatterns.structural.adapter

open class Socket {
    fun getVolt(): Volt {
        return Volt(120)
    }
}