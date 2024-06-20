package com.example.myapplication.designpatterns.behavioural.observer.publisher;

import com.example.myapplication.designpatterns.behavioural.observer.subscriber.Observer;

public interface Subject {
    void register(Observer observer);
    void unRegister(Observer observer);
    void notifyAllObservers();
}
