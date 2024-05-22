package com.example.myapplication.threading;

public class PrintOddEven {

    int count = 1;
    int limit = 50;

    private void printEven() {
        synchronized (this) {

            while (count < limit) {
                if (count % 2 == 1) {
                    try {
                        wait();
                    } catch (Exception e) {

                    }
                }
                System.out.println(count);
                count++;
                notify();
            }
        }
    }

    private void printOdd() {
        synchronized (this) {

            while (count < limit) {
                if (count % 2 == 0) {
                    try {
                        wait();
                    } catch (Exception e) {

                    }
                }
                System.out.println(count);
                count++;
                notify();
            }
        }
    }

    public static void main(String[] args) {

        PrintOddEven printOddEven = new PrintOddEven();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                printOddEven.printEven();
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                printOddEven.printOdd();
            }
        };

        t1.start();
        t2.start();
    }

}
