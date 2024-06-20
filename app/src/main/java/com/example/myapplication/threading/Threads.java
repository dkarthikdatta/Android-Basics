package com.example.myapplication.threading;

/**
 * We can define a thread in the following two ways:
 * <p>
 * By extending Thread class - negative point is cant extend any other - java can't support multiple inheritence
 * By implementing Runnable interface
 */
public class Threads {
    public static void main(String[] args) {
        ExtendingThread extendingThread = new ExtendingThread(); // each of our thread creates unique object and associate with it
        extendingThread.start();

        ImplementingRunnable implementingRunnable = new ImplementingRunnable();  // it shares the same object to multiple threads
        Thread implementingThread = new Thread(implementingRunnable);
        implementingThread.start();
    }
}

class ExtendingThread extends Thread {
    public void run() {
        System.out.println("Run method executed by child Thread");
    }

    public static void main(String[] args) {
        ExtendingThread t = new ExtendingThread();  // each of our thread creates unique object and associate with it
        t.start();
        System.out.println("Main method executed by main thread");
    }
}

class ImplementingRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Run method executed by child Thread " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ImplementingRunnable t = new ImplementingRunnable();    // it shares the same object to multiple threads
        Thread t1 = new Thread(t); // create thread
        t1.start(); // start thread automatically runs run
        System.out.println("Main method executed by main thread " + Thread.currentThread().getName());
    }
}