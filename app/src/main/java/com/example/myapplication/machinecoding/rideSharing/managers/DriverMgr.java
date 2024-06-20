package com.example.myapplication.machinecoding.rideSharing.managers;


import com.example.myapplication.machinecoding.rideSharing.dao.Driver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DriverMgr {
    private static DriverMgr driverMgrInstance = null;
    private static final Object object = new Object();
    private Map<String, Driver> driversMap;

    private DriverMgr() {
        driversMap = new HashMap<>();
    }

    public static DriverMgr getDriverMgr() {
        if (driverMgrInstance == null) {
            synchronized (object) {
                if (driverMgrInstance == null) {
                    driverMgrInstance = new DriverMgr();
                }
            }
        }
        return driverMgrInstance;
    }

    public void addDriver(String pDriverName, Driver pDriver) {
        driversMap.put(pDriverName, pDriver);
    }

    public Driver getDriver(String pDriverName) {
        return driversMap.get(pDriverName);
    }

    public Map<String, Driver> getDriversMap() {
        return driversMap;
    }
}

