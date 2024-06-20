package com.example.myapplication.designpatterns.behavioural.observer.subscriber;

public class PhoneDisplay implements Observer {

    String weather;

    @Override
    public void update(String weather) {
        this.weather = weather;
        System.out.println("Weather displayed in phone display is: " + weather);
    }
}
