package com.example.myapplication.designpatterns.creational.factory.abstractFactory.factories;

import com.example.myapplication.designpatterns.creational.factory.abstractFactory.objects.IButton;
import com.example.myapplication.designpatterns.creational.factory.abstractFactory.objects.ITextBox;
import com.example.myapplication.designpatterns.creational.factory.abstractFactory.objects.MacButton;
import com.example.myapplication.designpatterns.creational.factory.abstractFactory.objects.MacText;
import com.example.myapplication.designpatterns.creational.factory.abstractFactory.objects.WindowsText;

public class MacFactory implements GUIFactory{
    @Override
    public IButton createButton() {
        return new MacButton();
    }

    @Override
    public ITextBox createTextBox() {
        return new MacText();
    }
}
