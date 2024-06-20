package com.example.myapplication.machinecoding.foodDelivery.strategy;

import com.example.myapplication.machinecoding.foodDelivery.entities.DeliveryMetaData;

public class LocBasedDeliveryChargecalculationStrategy implements DeliveryChargeCalculationStrategy {
    public double calculateDeliveryCharge(DeliveryMetaData pDeliveryMetaData) {
        System.out.println("Delivery charge is decided based on location. Setting to 20 as default value for now");
        return 20.0;
    }
}

