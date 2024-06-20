package com.example.myapplication.machinecoding.foodDelivery.managers;

import com.example.myapplication.machinecoding.foodDelivery.entities.User;

import java.util.HashMap;

public class UserMgr {

    private static UserMgr INSTANCE = null;
    private static final Object object = new Object();
    private final HashMap<String, User> hashMap;

    private UserMgr() {
        hashMap = new HashMap<>();
    }

    public static UserMgr getUserMgr() {
        if (INSTANCE == null) {
            synchronized (object) {
                if (INSTANCE == null) {
                    INSTANCE = new UserMgr();
                }
            }
        }
        return INSTANCE;
    }

    public void addUser(String name, User user) {
        hashMap.put(name, user);
    }
}
