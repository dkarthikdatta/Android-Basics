package com.example.myapplication.machinecoding.foodDelivery.managers;


import com.example.myapplication.machinecoding.foodDelivery.entities.DeliveryMetaData;
import com.example.myapplication.machinecoding.foodDelivery.strategy.IDeliveryPartnerMatchingStrategy;
import com.example.myapplication.machinecoding.foodDelivery.strategy.LocBasedDeliveryPartnerMatchingStrategy;

import java.util.concurrent.locks.ReentrantLock;

public class StrategyMgr {
    private static StrategyMgr strategyMgrInstance = null;
    private static ReentrantLock lock = new ReentrantLock();

    private StrategyMgr() {
        // private constructor to prevent instantiation
    }

    public static StrategyMgr getStrategyMgr() {
        if (strategyMgrInstance == null) {
            lock.lock();
            try {
                if (strategyMgrInstance == null) {
                    strategyMgrInstance = new StrategyMgr();
                }
            } finally {
                lock.unlock();
            }
        }
        return strategyMgrInstance;
    }

    public IDeliveryPartnerMatchingStrategy determineDeliveryPartnerMatchingStrategy(DeliveryMetaData metaData) {
        System.out.println("Based on location, weather and other factors, setting partner strategy");
        return new LocBasedDeliveryPartnerMatchingStrategy();
    }
}


