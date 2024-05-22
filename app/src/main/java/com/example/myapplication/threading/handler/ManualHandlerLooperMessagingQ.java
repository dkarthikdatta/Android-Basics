package com.example.myapplication.threading.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

// Handler -> waiter
// Looper -> head chef - who just informs chef/thread what to do
// Order board -> Messaging Queue
// Thread -> Kitchen/inside place where order details execute
class KitchenThread extends Thread {
    public Waiter waiter; // handler

    @Override
    public void run() {
        // Setting up the kitchen
        Looper.prepare(); // Head chef gets ready

        // Creating a waiter to handle orders
        waiter = new Waiter(Looper.myLooper()); // Waiter is assigned to the kitchen

        // Head chef starts checking the order board
        Looper.loop();
    }
}

class Waiter extends Handler {
    public Waiter(Looper looper) {
        super(looper);
    }

    @Override
    public void handleMessage(Message msg) {
        // Chef processes the order
        Log.d("Kitchen", "Order received: " + msg.what);
    }
}


class ManualHandlerLooperMessagingQ {
    public static void main(String[] args) {
        // Setting up the kitchen thread
        KitchenThread kitchenThread = new KitchenThread();
        kitchenThread.start();

        // Waiter takes an order from a customer
        kitchenThread.waiter.post(new Runnable() {
            @Override
            public void run() {
                System.out.println("Prepare chicken biryani");
            }
        });
    }
}
