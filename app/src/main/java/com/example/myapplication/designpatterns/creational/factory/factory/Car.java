package com.example.myapplication.designpatterns.creational.factory.factory;

public class Car implements Vehicle {
    @Override
    public void createVehicle() {
        System.out.println("Creating a car");
    }
}
