package com.example.myapplication.designpatterns.creational.factory.abstractFactory.objects;

public class MacButton implements IButton{
    @Override
    public void press() {
        System.out.println("Mac button pressed");
    }
}
