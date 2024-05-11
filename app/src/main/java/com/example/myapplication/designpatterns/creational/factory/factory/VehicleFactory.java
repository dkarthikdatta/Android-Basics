package com.example.myapplication.designpatterns.creational.factory.factory;

public class VehicleFactory {

    public Vehicle createVehicle(String input) {
        Vehicle vehicle = null;
        if (input == "car") {
            vehicle = new Car();
        } else if (input == "bike") {
            vehicle = new Bike();
        }
        return vehicle;
    }


}
