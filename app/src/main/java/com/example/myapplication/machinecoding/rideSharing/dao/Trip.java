package com.example.myapplication.machinecoding.rideSharing.dao;

import com.example.myapplication.machinecoding.rideSharing.Location;
import com.example.myapplication.machinecoding.rideSharing.Util;
import com.example.myapplication.machinecoding.rideSharing.dao.Driver;
import com.example.myapplication.machinecoding.rideSharing.dao.Rider;
import com.example.myapplication.machinecoding.rideSharing.driverMatchingStrategy.DriverMatchingStrategy;
import com.example.myapplication.machinecoding.rideSharing.pricingStrategy.PricingStrategy;

import java.util.concurrent.atomic.AtomicInteger;

public class Trip {
    private final Rider rider;
    private final Driver driver;
    private final Location srcloc;
    private final Location dstLoc;
    private Util.TRIP_STATUS status;
    private final int tripId;
    private final double price;
    private PricingStrategy pricingStrategy;
    private DriverMatchingStrategy driverMatchingStrategy;
    private static final AtomicInteger nextTripId = new AtomicInteger(0);

    public Trip(Rider pRider, Driver pDriver, Location pSrcLoc, Location pDstLoc, double pPrice,
                PricingStrategy pPricingStrategy, DriverMatchingStrategy pDriverMatchingStrategy) {
        this.rider = pRider;
        this.driver = pDriver;
        this.srcloc = pSrcLoc;
        this.dstLoc = pDstLoc;
        this.price = pPrice;
        this.pricingStrategy = pPricingStrategy;
        this.driverMatchingStrategy = pDriverMatchingStrategy;
        this.status = Util.TRIP_STATUS.DRIVER_ON_THE_WAY;
        this.tripId = nextTripId.getAndIncrement();
    }

    public int getTripId() {
        return tripId;
    }

    public void displayTripDetails() {
        System.out.println();
        System.out.println("Trip id - " + tripId);
        System.out.println("Rider - " + rider.getRiderName());
        System.out.println("Driver - " + driver.getDriverName());
        System.out.println("Price - " + price);
        System.out.println("Locations - " + srcloc.getLatitude() + "," + srcloc.getLongitude() + " and " + dstLoc.getLatitude() + "," + dstLoc.getLongitude());
    }
}



