package com.example.myapplication.designpatterns.creational.factory.abstractFactory.factories;

public class GUIAbstractFactory {

    public GUIFactory createFactory(String input) {
        if (input == "mac") {
            return new MacFactory();
        } else {
            return new WindowsFactory();
        }
    }
}
