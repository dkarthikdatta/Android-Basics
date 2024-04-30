package com.example.myapplication.designpatterns.structural.observer.publisher;

import com.example.myapplication.designpatterns.structural.observer.subscriber.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject{

    private List<Observer> observers = new ArrayList<>();
    private String weather;

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unRegister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for(Observer observer: observers){
            observer.update(weather);
        }
    }

    public void setWeather(String weather){
        this.weather = weather;
    }
}
