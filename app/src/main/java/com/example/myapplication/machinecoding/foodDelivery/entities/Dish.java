package com.example.myapplication.machinecoding.foodDelivery.entities;


import com.example.myapplication.machinecoding.foodDelivery.enums.CUISINE;

import java.util.ArrayList;
import java.util.List;

public class Dish {
    private String name;
    private CUISINE cuisine;
    private String description;
    private double price;
    private List<String> dishImages;
    private List<DishAddOn> addons; // could have had decorator design pattern for add ons but
    // seemed overkill since restaurant owners are going to create addons

    public Dish(String pName, CUISINE pCuisine, double pPrice) {
        this.name = pName;
        this.cuisine = pCuisine;
        this.price = pPrice;
        this.dishImages = new ArrayList<>();
        this.addons = new ArrayList<>();
    }

    public void addAddOn(DishAddOn pAddOn) {
        addons.add(pAddOn);
    }

    // remove add on function
    public double getPrice() {
        double totalPrice = price;
        for (DishAddOn addOn : addons) {
            totalPrice += addOn.getPrice();
        }
        return totalPrice;
    }

    public String getDescription() {
        return description;
    }

    public String getDishName() {
        return name;
    }

    public CUISINE getCuisine() {
        return cuisine;
    }
}


