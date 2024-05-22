package com.example.myapplication.threading;

import android.os.Handler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exceutors {

    public static void main(String[] args) {
//        Thread t1 = new Thread(new Task()); //creating thread by implementing runnable method
//        t1.start();
//        System.out.println("main Thread name:  " + Thread.currentThread().getName());

        // todo 1000 tasks
//        for (int i = 0; i < 1000; i++) {
//            Thread childThread = new Thread(new Task()); //creating thread by implementing runnable method
//            childThread.start();
//        }


        // todo 1000 tasks, instead of creating 1000 threads, create 10 threads and submit 1000 tasks to those threads/
        // since creating a thread is an expensive operation
        // to create 10 threads and let threads themselves pic the tasks, use executoes

        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            service.execute(new Task());
        }

        // a blocking queue is used to store all tasks and submit task to threads safely
        // no of threads - pool size - similar to coroutines - CPU intensive - no of cores, IO intensive - many
        int coreCount = Runtime.getRuntime().availableProcessors(); // this will be pool size

        ExecutorService service1 = Executors.newFixedThreadPool(10);
        ExecutorService service2 = Executors.newCachedThreadPool();
        ExecutorService service3 = Executors.newScheduledThreadPool(10);
        ExecutorService service4 = Executors.newSingleThreadExecutor();

        /**
         * types of pools
         * 1. FixedThreadPool - same as above
         * 2. CachedThreadPool - no fixed pool, no blocking q. synchronous q, -> only single item. search for already created thread and free. if not available, new thread is created. Kill threads which are not active.
         * 3. ScheduledThreadPool - schedule a task after a delay - delay q.
         * 4. SingleThreadedExecutor - only one thread is present. recreates if thread is killed. synchronous is maintained - sequential of task is maintained
         */
    }
}

class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("child Thread name:  " + Thread.currentThread().getName());
    }
}

