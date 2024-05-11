package com.example.myapplication.designpatterns.creational.factory.abstractFactory.objects;

public class WindowsButton implements IButton{
    @Override
    public void press() {
        System.out.println("Windows button pressed");

    }
}
