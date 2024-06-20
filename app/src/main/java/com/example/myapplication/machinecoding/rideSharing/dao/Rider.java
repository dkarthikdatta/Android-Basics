package com.example.myapplication.machinecoding.rideSharing.dao;

import com.example.myapplication.machinecoding.rideSharing.RATING;

import java.util.*;

public class Rider {
    private final String name;
    private final RATING rating;

    public Rider(String pName, RATING pRating) {
        this.name = pName;
        this.rating = pRating;
    }

    public String getRiderName() {
        return name;
    }

    public RATING getRating() {
        return rating;
    }
}



