package com.example.myapplication.machinecoding.foodDelivery.entities;

import com.example.myapplication.machinecoding.foodDelivery.enums.RATING;

import java.lang.String;

public class IPartner {
    protected String name;
    protected RATING rating;

    public IPartner(String pName) {
        this.name = pName;
        this.rating = RATING.UNASSIGNED;
    }

    public String getName() {
        return this.name;
    }

    // public abstract void performKyc();
}

