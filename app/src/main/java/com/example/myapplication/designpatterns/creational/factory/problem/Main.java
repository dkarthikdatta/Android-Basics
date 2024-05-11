package com.example.myapplication.designpatterns.creational.factory.problem;

public class Main {

    public static void main(String[] args) {

        //client needs to take care about the what vehicle to create.

        Vehicle vehicle = null;

        String input = "car";

        if (input == "car") {
            vehicle = new Car();
        } else if (input == "bike") {
            vehicle = new Bike();
        }

        vehicle.createVehicle();
    }
}
