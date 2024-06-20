package com.example.myapplication.machinecoding.foodDelivery.entities;

import java.util.concurrent.atomic.AtomicInteger;

public class User {
    AtomicInteger id = new AtomicInteger(0);
    String name;
    Location location;

    public User(String name, Location location) {
        this.name = name;
        this.location = location;
        id.addAndGet(1);
    }

    public String getId() {
        return id.toString();
    }

    public Location getLocation() {
        return location;
    }
}
