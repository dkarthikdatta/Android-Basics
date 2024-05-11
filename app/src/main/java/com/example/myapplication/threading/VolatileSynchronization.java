package com.example.myapplication.threading;

/**
 * It's important to understand that there are two aspects to thread safety.
 * 1. execution control, and
 * 2. memory visibility
 * <p>
 * synchronized can solve 1, 2
 * volatile can solve  only 2
 */
public class VolatileSynchronization {

    volatile boolean flag = true;

    public static void main(String[] args) {
        VolatileSynchronization volatileSynchronization = new VolatileSynchronization();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                volatileSynchronization.flag = false;
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (volatileSynchronization.flag) {
                    System.out.println("im running");
                }
            }
        };
        t2.start();
        t1.start();

    }
}
