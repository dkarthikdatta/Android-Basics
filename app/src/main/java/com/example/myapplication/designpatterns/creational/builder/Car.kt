package com.example.myapplication.designpatterns.creational.builder

class Car(carBuilder: CarBuilder) {
    val brand: String?
    val type: String?
    val color: String?

    init {
        this.brand = carBuilder.brand
        this.type = carBuilder.type
        this.color = carBuilder.color
    }

    class CarBuilder() {
        var brand: String? = null
        var type: String? = null
        var color: String? = null

        fun brand(brand: String): CarBuilder {
            this.brand = brand
            return this
        }

        fun type(type: String): CarBuilder {
            this.type = type
            return this
        }

        fun color(color: String): CarBuilder {
            this.color = color
            return this
        }

        fun build(): Car {
            return Car(this)
        }
    }
}