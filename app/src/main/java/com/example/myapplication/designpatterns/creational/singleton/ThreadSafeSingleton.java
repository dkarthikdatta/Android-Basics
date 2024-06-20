package com.example.myapplication.designpatterns.creational.singleton;


public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance = null;
    private static final Object mutex = new Object();

    private ThreadSafeSingleton() {
    }

    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (mutex) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

}