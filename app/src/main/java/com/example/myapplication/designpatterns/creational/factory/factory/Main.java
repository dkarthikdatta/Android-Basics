package com.example.myapplication.designpatterns.creational.factory.factory;

public class Main {
    public static void main(String[] args) {

        // client doesn't bother about how to create vehicle
        Vehicle vehicle = new VehicleFactory().createVehicle("car");
        vehicle.createVehicle();
    }
}
