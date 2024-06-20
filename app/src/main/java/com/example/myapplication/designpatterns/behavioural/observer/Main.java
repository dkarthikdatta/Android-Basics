package com.example.myapplication.designpatterns.behavioural.observer;

import com.example.myapplication.designpatterns.behavioural.observer.publisher.WeatherStation;
import com.example.myapplication.designpatterns.behavioural.observer.subscriber.PhoneDisplay;
import com.example.myapplication.designpatterns.behavioural.observer.subscriber.TVDisplay;

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
