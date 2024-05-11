package com.example.myapplication.designpatterns.creational.factory.abstractFactory.objects;

public class WindowsText implements ITextBox{
    @Override
    public void showText() {
        System.out.println("windows text shown");

    }
}
