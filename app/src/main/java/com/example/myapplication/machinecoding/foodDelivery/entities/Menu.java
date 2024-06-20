package com.example.myapplication.machinecoding.foodDelivery.entities;

import com.example.myapplication.machinecoding.foodDelivery.entities.Dish;

import java.util.List;

public class Menu {
    private List<Dish> dishes;

    public Menu(List<Dish> pDishes) {
        this.dishes = pDishes;
    }
}


