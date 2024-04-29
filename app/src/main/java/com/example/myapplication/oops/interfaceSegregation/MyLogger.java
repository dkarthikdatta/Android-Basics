package com.example.myapplication.oops.interfaceSegregation;

public class MyLogger {

    MyInterface myInterface;

    public MyLogger() {

    }

    public void setMyInterface(MyInterface myInterface) {
        this.myInterface = myInterface;
    }

    public void callThisLogger(String s) {
        if (myInterface != null) {
            myInterface.myFunction1(s);
        } else {
            System.out.println("Calling logger from default: " + s);
        }

    }
}
