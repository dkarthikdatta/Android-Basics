package com.example.myapplication.designpatterns.structural.adapter

interface SocketAdapter {

    fun get120Volts(): Volt
    fun get60Volts(): Volt
    fun get30Volts(): Volt
}