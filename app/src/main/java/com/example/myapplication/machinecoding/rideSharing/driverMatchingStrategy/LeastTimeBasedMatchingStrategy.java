package com.example.myapplication.machinecoding.rideSharing.driverMatchingStrategy;

import com.example.myapplication.machinecoding.rideSharing.TripMetaData;
import com.example.myapplication.machinecoding.rideSharing.dao.Driver;
import com.example.myapplication.machinecoding.rideSharing.driverMatchingStrategy.DriverMatchingStrategy;
import com.example.myapplication.machinecoding.rideSharing.managers.DriverMgr;

import java.util.Map;
import java.util.Iterator;

public class LeastTimeBasedMatchingStrategy implements DriverMatchingStrategy {
    @Override
    public Driver matchDriver(TripMetaData pMetaData) {
        DriverMgr driverMgr = DriverMgr.getDriverMgr();

        if (driverMgr.getDriversMap().size() == 0) {
            System.out.println("No drivers! What service is this huh?");
        }
        System.out.println("Using quadtree to see nearest cabs, using driver manager to get details of drivers and send notifications");

        // Here we can call quadtree algo to get nearest cabs
        Iterator<Map.Entry<String, Driver>> iterator = driverMgr.getDriversMap().entrySet().iterator();
        Driver driver = iterator.next().getValue();

        System.out.println("Setting " + driver.getDriverName() + " as driver");
        pMetaData.setDriverRating(driver.getRating());
        return driver;
    }
}


