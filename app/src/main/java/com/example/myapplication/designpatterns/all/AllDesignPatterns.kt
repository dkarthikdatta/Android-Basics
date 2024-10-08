package com.example.myapplication.designpatterns.all

fun main() {

    /**
     * creational
     */

    // 1. Singleton
//    val singletonDesignPattern1 = SingletonDesignPattern.getInstance()
//    println(singletonDesignPattern1.getAnyValue())
//    println(singletonDesignPattern1) // same instance
//
//    val singletonDesignPattern2 = SingletonDesignPattern.getInstance()
//    println(singletonDesignPattern2.getAnyValue())
//    println(singletonDesignPattern2) // same instance

    // 2. factory
//    val vehicleFactory = VehicleFactory()
//    println(vehicleFactory.createVehicle("car"))

    // 3. Abstract Factory
//    val computerFactory = ComputerFactory()
//    val guiComponent = computerFactory.createSpecificComputerFactory("windows")
//    guiComponent.createButton()

    // 4. Builder
    val lorryBuilder =
        LorryBuilder().brand("TATA").horn("TUITUI").color("RED").wheels(20).lights(16).build()
    lorryBuilder.getLorryData()

    /**
     * structural
     */

    // 1. adapter
}

class AllDesignPatterns {

}

// creation
// 1. singleton - only one instance of class throughout the app.  logging, drivers objects, caching, and thread pool.
class SingletonDesignPattern private constructor() {

    companion object {
        private var instance: SingletonDesignPattern? = null
        private val lock = Object()
        fun getInstance(): SingletonDesignPattern {
            return instance ?: synchronized(this) {
                instance ?: SingletonDesignPattern().also { instance = it }
            }
        }
    }

    fun getAnyValue(): String {
        return "singleton return"
    }
}

// 2. factory - to create objects just by input of type on client side. creating of objects logic to be handled internally
class VehicleFactory {
    fun createVehicle(type: String): Vehicle {
        if (type == "car") {
            val car = Car()
            car.createVehicle()
            return car
        } else if (type == "bike") {
            val bike = Bike()
            bike.createVehicle()
            return bike
        }
        return Bike()
    }
}

interface Vehicle {
    fun createVehicle()
}

class Car : Vehicle {
    override fun createVehicle() {
        println("created Car")
    }
}

class Bike : Vehicle {
    override fun createVehicle() {
        println("created Bike")
    }

}

// 3. Abstract factory - to create object which are of type dependent
interface GUIComponent {
    fun createButton()
    fun createText()
}

class WindowsFactory : GUIComponent {
    override fun createButton() {
        println("Creating Windows Button")
    }

    override fun createText() {
        println("Creating Windows Text")
    }
}

class MacFactory : GUIComponent {
    override fun createButton() {
        println("Creating Mac Button")
    }

    override fun createText() {
        println("Creating Mac Text")
    }
}

class ComputerFactory {
    fun createSpecificComputerFactory(computerName: String): GUIComponent {
        if (computerName == "mac") {
            return MacFactory()
        }
        return WindowsFactory()
    }
}

// 4. Builder Pattern - when so many initialization properties and are optional
class Lorry {
    var brand: String? = null
    var color: String? = null
    var wheels: Int? = null
    var lights: Int? = null
    var horn: String? = null

    fun getLorryData() {
        println("brand = $brand, color = $color, wheels = $wheels, lights = $lights, horn = $horn")
    }
}

class LorryBuilder {

    private val lorry: Lorry = Lorry()

    fun brand(brand: String): LorryBuilder {
        lorry.apply { this.brand = brand }
        return this
    }

    fun color(color: String): LorryBuilder {
        lorry.apply { this.color = color }
        return this
    }

    fun wheels(wheels: Int): LorryBuilder {
        lorry.apply { this.wheels = wheels }
        return this
    }

    fun lights(lights: Int): LorryBuilder {
        lorry.apply { this.lights = lights }
        return this
    }

    fun horn(horn: String): LorryBuilder {
        lorry.apply { this.horn = horn }
        return this
    }

    fun build(): Lorry {
        return lorry
    }
}

// 1. adapter

