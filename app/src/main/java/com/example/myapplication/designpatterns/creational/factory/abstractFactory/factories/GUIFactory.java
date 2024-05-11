package com.example.myapplication.designpatterns.creational.factory.abstractFactory.factories;

import com.example.myapplication.designpatterns.creational.factory.abstractFactory.objects.IButton;
import com.example.myapplication.designpatterns.creational.factory.abstractFactory.objects.ITextBox;

public interface GUIFactory {
    IButton createButton();
    ITextBox createTextBox();

}
