package com.example.myapplication.designpatterns.behavioural.strategy;

public class PayByCreditCard implements PaymentStrategy{
    boolean validCard = false;
    @Override
    public boolean pay(int amount) {
        if(validCard){
            System.out.println("Paying by credit card of amount = " + amount);
            return true;
        }
        return false;
    }

    @Override
    public void collectPaymentDetails() {
        // collect credit card details and make CreditCard object
        validCard = true;
    }
}
