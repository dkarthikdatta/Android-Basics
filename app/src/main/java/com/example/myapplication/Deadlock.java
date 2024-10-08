package com.example.myapplication;

public class Deadlock {

    // thread 1 is waiting for thread 2
    // thread 2 is waiting for thread 1


    public static void main(String[] args) {


        Runnable r1 = new Runnable() {

            @Override
            public void run() {

            }
        };


        Runnable r2  = new Runnable() {
            @Override
            public void run() {

            }
        };

        Thread t1= new Thread(r1);

        t1.run();


    }
}
