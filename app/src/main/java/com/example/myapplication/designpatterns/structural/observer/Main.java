package com.example.myapplication.designpatterns.structural.observer;

import com.example.myapplication.designpatterns.structural.observer.publisher.WeatherStation;
import com.example.myapplication.designpatterns.structural.observer.subscriber.Observer;
import com.example.myapplication.designpatterns.structural.observer.subscriber.PhoneDisplay;
import com.example.myapplication.designpatterns.structural.observer.subscriber.TVDisplay;

public class Main {

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        PhoneDisplay phoneDisplay = new PhoneDisplay();
        TVDisplay tvDisplay = new TVDisplay();
        weatherStation.register(phoneDisplay);
        weatherStation.register(tvDisplay);

        weatherStation.setWeather("39 Degrees");
        weatherStation.notifyAllObservers();
    }
}
