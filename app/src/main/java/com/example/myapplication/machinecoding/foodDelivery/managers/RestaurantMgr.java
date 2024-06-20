package com.example.myapplication.machinecoding.foodDelivery.managers;

import com.example.myapplication.machinecoding.foodDelivery.entities.Restaurant;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class RestaurantMgr {
    private static RestaurantMgr restaurantMgrInstance = null;
    private static final ReentrantLock mtx = new ReentrantLock();
    private Map<String, Restaurant> restaurantsMap = new HashMap<>();

    private RestaurantMgr() {
        // private constructor to prevent instantiation
    }

    public static RestaurantMgr getRestaurantMgr() {
        if (restaurantMgrInstance == null) {
            mtx.lock();
            try {
                if (restaurantMgrInstance == null) {
                    restaurantMgrInstance = new RestaurantMgr();
                }
            } finally {
                mtx.unlock();
            }
        }
        return restaurantMgrInstance;
    }

    public void addRestaurant(String pRestaurantName, Restaurant pRestaurant) {
        restaurantsMap.put(pRestaurantName, pRestaurant);
    }

    public Restaurant getRestaurant(String pRestaurantName) {
        return restaurantsMap.get(pRestaurantName);
    }
}


