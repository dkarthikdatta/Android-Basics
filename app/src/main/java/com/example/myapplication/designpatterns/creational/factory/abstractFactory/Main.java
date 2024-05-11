package com.example.myapplication.designpatterns.creational.factory.abstractFactory;

import com.example.myapplication.designpatterns.creational.factory.abstractFactory.factories.GUIAbstractFactory;
import com.example.myapplication.designpatterns.creational.factory.abstractFactory.factories.GUIFactory;
import com.example.myapplication.designpatterns.creational.factory.abstractFactory.objects.IButton;

public class Main {
    public static void main(String[] args) {
        GUIAbstractFactory guiAbstractFactory = new GUIAbstractFactory();
        GUIFactory guiFactory =  guiAbstractFactory.createFactory("windows");
        IButton button = guiFactory.createButton();
        button.press();
    }
}
