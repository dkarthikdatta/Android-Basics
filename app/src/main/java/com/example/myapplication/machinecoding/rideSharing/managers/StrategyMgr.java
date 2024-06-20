package com.example.myapplication.machinecoding.rideSharing.managers;

import com.example.myapplication.machinecoding.rideSharing.pricingStrategy.DefaultPricingStrategy;
import com.example.myapplication.machinecoding.rideSharing.driverMatchingStrategy.DriverMatchingStrategy;
import com.example.myapplication.machinecoding.rideSharing.driverMatchingStrategy.LeastTimeBasedMatchingStrategy;
import com.example.myapplication.machinecoding.rideSharing.pricingStrategy.PricingStrategy;
import com.example.myapplication.machinecoding.rideSharing.TripMetaData;
import com.example.myapplication.machinecoding.rideSharing.pricingStrategy.RatingBasedPricingStrategy;

public class StrategyMgr {
    private static StrategyMgr strategyMgrInstance = null;
    private static final Object object = new Object();

    private StrategyMgr() {
        // private constructor to prevent instantiation
    }

    public static StrategyMgr getStrategyMgr() {
        if (strategyMgrInstance == null) {
            synchronized (object) {
                if (strategyMgrInstance == null) {
                    strategyMgrInstance = new StrategyMgr();
                }
            }
        }
        return strategyMgrInstance;
    }

    public PricingStrategy determinePricingStrategy(TripMetaData metaData) {
        System.out.println("Based on location and other factors, setting pricing strategy");
        return new RatingBasedPricingStrategy();
    }

    public DriverMatchingStrategy determineMatchingStrategy(TripMetaData metaData) {
        System.out.println("Based on location and other factors, setting matching strategy");
        return new LeastTimeBasedMatchingStrategy();
    }
}



