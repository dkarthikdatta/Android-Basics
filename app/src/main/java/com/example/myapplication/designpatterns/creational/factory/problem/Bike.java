package com.example.myapplication.designpatterns.creational.factory.problem;

public class Bike implements Vehicle {
    @Override
    public void createVehicle() {
        System.out.println("Creatimg Bike");
    }
}
