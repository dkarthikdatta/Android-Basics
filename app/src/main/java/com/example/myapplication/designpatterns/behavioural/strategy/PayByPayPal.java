package com.example.myapplication.designpatterns.behavioural.strategy;

public class PayByPayPal implements PaymentStrategy{

    boolean signIn = false;

    @Override
    public boolean pay(int amount) {
        if(signIn){
            System.out.println("Paying by paypal of amount = " + amount);
            return true;
        }
        return false;
    }

    @Override
    public void collectPaymentDetails() {
        // collect details of the paypal account, user id and pass
        // verify and if successful, make signIn true
        signIn = true;
    }
}
