package com.example.myapplication.designpatterns.behavioural.observer.publisher;

import com.example.myapplication.designpatterns.behavioural.observer.subscriber.Observer;

public interface Subject {
    public void register(Observer observer);
    public void unRegister(Observer observer);
    public void notifyAllObservers();


}
