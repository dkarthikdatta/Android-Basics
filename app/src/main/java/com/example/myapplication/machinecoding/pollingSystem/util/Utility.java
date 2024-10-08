package com.example.myapplication.machinecoding.pollingSystem.util;

import java.util.UUID;

public class Utility {
    public static String generateUniqueId() {
        return UUID.randomUUID().toString();
    }
}
