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


    // without synchronized keyword

    /**
     * . Since your instance variable is static final, this means it will be constructed when the
     * class is initially loaded. By calling getInstance(), the classloaders brings in the class and,
     * as part of that, constructs the INSTANCE member before allowing the call through to getInstance() to proceed.
     *
     *
     * The classloader itself has locking mechanisms to prevent concurrent execution by multiple
     * threads and therefore all calls to getInstance() (including the first, immediately following
     * the loading of the class) will return the already-initialised value.
     */
    private static final class InstanceHolder {
        static final ThreadSafeSingleton instance = new ThreadSafeSingleton();
    }

    public static ThreadSafeSingleton getInstanceWithoutSynchronized() {
        return InstanceHolder.instance;
    }


}