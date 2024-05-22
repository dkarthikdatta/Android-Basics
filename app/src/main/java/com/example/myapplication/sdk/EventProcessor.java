package com.example.myapplication.sdk;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class EventProcessor {

    private MyDb myDb;

    //    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

    public EventProcessor(MyDb myDb) {
        this.myDb = myDb;
    }

    public void processEvent(Student student, int id) {
        System.out.println("MYSDK added task to q before executing, id - " + id);
        executor.execute(() -> {
            System.out.println("MYSDK added task to q after executing");
            BlockingQueue<Runnable> q = executor.getQueue();
            System.out.println("MYSDK Blocking q items " + q.size());

            System.out.println("MYSDK making extensive operations");
            BigInteger veryBig = new BigInteger(1000, new Random());
            veryBig.nextProbablePrime();

//            try {
//                Thread.sleep(1000); // making some operations
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            if (myDb.getAllStudentList().size() < 15) {
                myDb.addStudent(student);
            } else {
                // making api call
                System.out.println("MYSDK making an api call");
                BigInteger veryBig2 = new BigInteger(1000, new Random());
                BigInteger x = veryBig2.nextProbablePrime();
                System.out.println("next prime = " + x.toString());

//                try {
//                    System.out.println("MYSDK making an api call");
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                myDb.deleteAllStudents();
                myDb.addStudent(student);
            }
        });
    }
}
