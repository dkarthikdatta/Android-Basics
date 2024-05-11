package com.example.myapplication.designpatterns.creational.factory.abstractFactory.factories;

import com.example.myapplication.designpatterns.creational.factory.abstractFactory.objects.IButton;
import com.example.myapplication.designpatterns.creational.factory.abstractFactory.objects.ITextBox;
import com.example.myapplication.designpatterns.creational.factory.abstractFactory.objects.WindowsButton;
import com.example.myapplication.designpatterns.creational.factory.abstractFactory.objects.WindowsText;

public class WindowsFactory implements GUIFactory{

    @Override
    public IButton createButton() {
        return new WindowsButton();
    }

    @Override
    public ITextBox createTextBox() {
        return new WindowsText();
    }
}
