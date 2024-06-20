package com.example.myapplication.designpatterns.behavioural.strategy;

public interface PaymentStrategy {
    boolean pay(int amount);
    void collectPaymentDetails();
}
