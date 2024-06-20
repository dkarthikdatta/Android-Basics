package com.example.myapplication.designpatterns.behavioural.strategy;

public class StrategyManager {

    private StrategyManager() {
    }

    private static final Object lock = new Object();

    private static StrategyManager INSTNACE = null;

    public static StrategyManager getInstance() {
        if (INSTNACE == null) {
            synchronized (lock) {
                if (INSTNACE == null) {
                    INSTNACE = new StrategyManager();
                }
            }
        }
        return INSTNACE;
    }

    private PaymentStrategy currentPaymentStrategy = new PayByCreditCard();

    public boolean pay(int amount) {
        return currentPaymentStrategy.pay(amount);
    }

    public void collectDetails(){
        currentPaymentStrategy.collectPaymentDetails();
    }

}
