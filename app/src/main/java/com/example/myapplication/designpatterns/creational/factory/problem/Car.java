package com.example.myapplication.designpatterns.creational.factory.problem;

public class Car implements Vehicle{
    @Override
    public void createVehicle() {
        System.out.println("Creating a car");
    }
}
