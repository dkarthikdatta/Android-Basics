package com.example.myapplication.machinecoding.foodDelivery.entities;

import com.example.myapplication.machinecoding.foodDelivery.notification.NotificationMgr;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Restaurant {
    private String name; // storing name as id itself for now. id should be generated and name should be passed in ctor
    private boolean isAvail;
    private Location location;
    private Menu menu;
    private RestaurantOwner owner; // can support multiple owners, but for simplicity, one owner

    public Restaurant(String pName, RestaurantOwner pOwner, Location pLoc) {
        this.name = pName;
        this.owner = pOwner;
        this.location = pLoc;
        this.isAvail = false;
        this.menu = null; // can choose to pass in the constructor but keeping it apart for now
    }

    public void addMenu(Menu pMenu) {
        this.menu = pMenu;
    }

    public String getId() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

}


