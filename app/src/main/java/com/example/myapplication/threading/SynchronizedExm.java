package com.example.myapplication.threading;

public class SynchronizedExm {
    private int counter = 0;

    public void increment() {
        // Critical section
        synchronized (this) {
            counter++;
        }
    }

    public int getCounter() {
        return counter;
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedExm example = new SynchronizedExm();

        // Create multiple threads that increment the counter
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                example.increment();
                System.out.println("in thread 1, counter value = " + example.getCounter());
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                example.increment();
                System.out.println("in thread 2, counter value = " + example.getCounter());
            }
        });

        // Start the threads
        thread1.start();
        thread2.start();

        // Wait for the threads to finish
        thread1.join();
        thread2.join();

        // Print the final counter value
        System.out.println("Final counter value: " + example.getCounter());
    }
}

