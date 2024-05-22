package com.example.myapplication.threading;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

/**
 * It's important to understand that there are two aspects to thread safety.
 * 1. execution control, and
 * 2. memory visibility
 * <p>
 * synchronized can solve 1, 2
 * volatile can solve  only 2
 */
public class VolatileSynchronization {

    // if not used volatile,
    // when both threads are started, t2 while loop runs.
    // t1 makes flag to false and expects t2 to stop while loop.
    // but it wont as this flag is cached in the thread memory separately and update in one thread doesn't update in another

    // volatile makes the update visible immediately as the variable gets update by flushing the update
    // solves visibility problem -> when ony one thread is updating the value and remaining are using it
    volatile boolean flag = true;
    int counter = 0;

    public static void main(String[] args) {

    }

    // synchronized
    // if synchronized lock is not present, since in counter++, we are reading and updating the counter value from both threads,
    // volatile also doesn't work. if volatile, read same value, both threads updates this value separately and final answer will be one less. (since both started from same value, 22 adds done)
    // synchronized -> when both read and write operations are done from multiple threads.

    public int incrementCounter() {
        // critical section
        synchronized (this) {
            return counter++;
        }
    }
}

class Volatile {
    public static void main(String[] args) throws InterruptedException {
        VolatileSynchronization volatileSynchronization = new VolatileSynchronization();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        volatileSynchronization.flag = false;
                    }
                };
                Timer timer = new Timer();
                timer.schedule(timerTask, 100);
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (volatileSynchronization.flag) {
                    System.out.println("im running because flag is true " + System.currentTimeMillis());
                }
                System.out.println("im stopped running because flag is false " + System.currentTimeMillis());
            }
        };
        t2.start();
        t1.start();
        t1.join();
        t2.join();
    }
}

class Synchronization {
    public static void main(String[] args) {
        VolatileSynchronization volatileSynchronization = new VolatileSynchronization();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                int limit = 0;
                while (limit < 10) {
                    System.out.println("Thread 1 increment = " + volatileSynchronization.incrementCounter());
                    limit++;
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                int limit = 0;
                while (limit < 10) {
                    System.out.println("Thread 2 increment = " + volatileSynchronization.incrementCounter());
                    limit++;
                }
            }
        };
        t1.start();
        t2.start();
    }
}
