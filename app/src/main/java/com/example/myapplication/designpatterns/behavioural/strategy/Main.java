package com.example.myapplication.designpatterns.behavioural.strategy;

public class Main {
    public static void main(String[] args) {
        StrategyManager.getInstance().collectDetails();
        StrategyManager.getInstance().pay(100);
    }
}
