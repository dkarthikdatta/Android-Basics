package com.example.myapplication.machinecoding.rideSharing.dao;

import com.example.myapplication.machinecoding.rideSharing.RATING;

import java.lang.String;
public class Driver {
    private final String name;
    private boolean avail;
    private final RATING rating;

    public Driver(String pName, RATING pRating) {
        this.name = pName;
        this.rating = pRating;
        this.avail = false;
    }

    public void updateAvail(boolean pAvail) {
        this.avail = pAvail;
    }

    public String getDriverName() {
        return this.name;
    }

    public RATING getRating() {
        return this.rating;
    }
}

