package com.example.myapplication.machinecoding.rideSharing.pricingStrategy;


import com.example.myapplication.machinecoding.rideSharing.TripMetaData;
import com.example.myapplication.machinecoding.rideSharing.pricingStrategy.PricingStrategy;

public class DefaultPricingStrategy implements PricingStrategy {
    public double calculatePrice(TripMetaData pTripMetaData) {
        System.out.println("Based on default strategy, price is 100");
        return 100.0;
    }
}

