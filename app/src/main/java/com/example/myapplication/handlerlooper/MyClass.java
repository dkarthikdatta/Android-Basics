package com.example.myapplication.handlerlooper;

public class MyClass{

    int count = 1;

    static int N;

    public void printOddNumber()
    {
        synchronized (this)
        {
            while (count < N) {
                if (count % 2 == 0) {
                    try {
                        System.out.println("in odd number waiting state, count = " + count);
                        wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Result "+ count);
                count++;
                notify();
            }
        }
    }

    public void printEvenNumber()
    {
        synchronized (this)
        {
            while (count < N) {
                if (count % 2 == 1) {
                    try {
                        System.out.println("in even number waiting state, count = " + count);
                        wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Result " + count);
                count++;
                notify();
            }
        }
    }
    public static void main(String[] args)
    {
        N = 10;
        MyClass myClass = new MyClass();
        Thread t1 = new Thread(new Runnable() {
            public void run()
            {
                myClass.printEvenNumber();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run()
            {
                myClass.printOddNumber();
            }
        });
        t1.start();
        t2.start();
    }
}
