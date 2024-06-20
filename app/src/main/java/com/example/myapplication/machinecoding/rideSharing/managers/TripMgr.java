package com.example.myapplication.machinecoding.rideSharing.managers;

import com.example.myapplication.machinecoding.rideSharing.driverMatchingStrategy.DriverMatchingStrategy;
import com.example.myapplication.machinecoding.rideSharing.Location;
import com.example.myapplication.machinecoding.rideSharing.pricingStrategy.PricingStrategy;
import com.example.myapplication.machinecoding.rideSharing.dao.Trip;
import com.example.myapplication.machinecoding.rideSharing.TripMetaData;
import com.example.myapplication.machinecoding.rideSharing.dao.Driver;
import com.example.myapplication.machinecoding.rideSharing.dao.Rider;

import java.util.HashMap;

public class TripMgr {
    private static TripMgr tripMgrInstance = null;
    private static final Object object = new Object();
    private final HashMap<Integer, Trip> tripsInfo;
    private final HashMap<Integer, TripMetaData> tripsMetaDataInfo;

    private TripMgr() {
        tripsInfo = new HashMap<>();
        tripsMetaDataInfo = new HashMap<>();
    }

    public static TripMgr getTripMgr() {
        if (tripMgrInstance == null) {
            synchronized (object) {
                if (tripMgrInstance == null) {
                    tripMgrInstance = new TripMgr();
                }
            }
        }
        return tripMgrInstance;
    }

    public void createTrip(Rider pRider, Location pSrcLoc, Location pDstLoc) {
        TripMetaData metaData = new TripMetaData(pSrcLoc, pDstLoc, pRider.getRating());
        StrategyMgr strategyMgr = StrategyMgr.getStrategyMgr();
        PricingStrategy pricingStrategy = strategyMgr.determinePricingStrategy(metaData);
        DriverMatchingStrategy driverMatchingStrategy = strategyMgr.determineMatchingStrategy(metaData);

        Driver driver = driverMatchingStrategy.matchDriver(metaData);
        double tripPrice = pricingStrategy.calculatePrice(metaData);

        Trip trip = new Trip(pRider, driver, pSrcLoc, pDstLoc, tripPrice, pricingStrategy, driverMatchingStrategy);
        int tripId = trip.getTripId();
        tripsInfo.put(tripId, trip);
        tripsMetaDataInfo.put(tripId, metaData);
    }

    public HashMap<Integer, Trip> getTripsMap() {
        return tripsInfo;
    }
}



