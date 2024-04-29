package com.example.myapplication.designpatterns.creational.builder

class MainClient {
    fun main() {
        val car: Car  = Car.CarBuilder().brand("Tesla").color("Black").build()
    }
}