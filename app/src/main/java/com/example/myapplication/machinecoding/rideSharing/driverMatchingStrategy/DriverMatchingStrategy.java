package com.example.myapplication.machinecoding.rideSharing.driverMatchingStrategy;

import com.example.myapplication.machinecoding.rideSharing.TripMetaData;
import com.example.myapplication.machinecoding.rideSharing.dao.Driver;

public interface DriverMatchingStrategy {
    Driver matchDriver(TripMetaData tripMetaData);
}


