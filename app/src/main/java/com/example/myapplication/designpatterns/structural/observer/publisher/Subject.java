package com.example.myapplication.designpatterns.structural.observer.publisher;

import com.example.myapplication.designpatterns.structural.observer.subscriber.Observer;

public interface Subject {
    public void register(Observer observer);
    public void unRegister(Observer observer);
    public void notifyAllObservers();


}
