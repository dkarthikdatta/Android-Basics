package com.example.myapplication.machinecoding.rideSharing.pricingStrategy;


import com.example.myapplication.machinecoding.rideSharing.TripMetaData;

public interface PricingStrategy {
    double calculatePrice(TripMetaData pTripMetaData);
}



