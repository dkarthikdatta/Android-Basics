package com.example.myapplication.oops.interfaceSegregation;

public class Client {

    public static void main(String[] args) {

        MyLogger logger = new MyLogger();
        MyInterface myInterface = new MyInterface() {
            @Override
            public void myFunction() {

            }

            @Override
            public void myFunction1(String s) {
                System.out.println("Calling from custom Interface function by client: " + s);
            }

            @Override
            public void myFunction2() {

            }
        };

        logger.setMyInterface(myInterface);

        logger.callThisLogger("I am a log statement");
    }
}
