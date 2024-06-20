package com.example.myapplication.machinecoding.foodDelivery.entities;

import java.util.List;

public class DishAddOn {
    private String name;
    private String description;
    private double price;
    private boolean isAvail;
    private List<String> images;

    public DishAddOn(String pName, double pPrice) {
        this.name = pName;
        this.price = pPrice;
    }

    // Getters and setters
    public double getPrice() {
        return price;
    }
}


