package com.example.myapplication.machinecoding.rideSharing.managers;


import com.example.myapplication.machinecoding.rideSharing.dao.Rider;

import java.util.concurrent.locks.ReentrantLock;
import java.util.HashMap;

public class RiderMgr {
    private static RiderMgr riderMgrInstance = null;
    private static final Object object = new Object();
    private final HashMap<String, Rider> ridersMap;

    private RiderMgr() {
        ridersMap = new HashMap<>();
    }

    public static RiderMgr getRiderMgr() {
        if (riderMgrInstance == null) {
            synchronized (object) {
                if (riderMgrInstance == null) {
                    riderMgrInstance = new RiderMgr();
                }
            }
        }
        return riderMgrInstance;
    }

    public void addRider(String pRiderName, Rider pRider) {
        ridersMap.put(pRiderName, pRider);
    }

    public Rider getRider(String pRiderName) {
        return ridersMap.get(pRiderName);
    }
}

