package com.example.myapplication.handlerlooper;

public class MyClass{

    int count = 1;

    static int N;

    public void printOddNumber()
    {
        synchronized (this)
        {
            while (count < N) {
                while (count % 2 == 0) {
                    try {
                        wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(count + " ");
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
                while (count % 2 == 1) {
                    try {
                        wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(count + " ");
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
