package com.example.myapplication.designpatterns

import com.example.myapplication.designpatterns.creational.builder.Car

class DriverClass {
    val car: Car = Car.CarBuilder().type("Petrol").color("black").brand("MG").build()
    val myInterface: MyInterface = ObjectA()
    val objectC: ObjectC = ObjectD()
}