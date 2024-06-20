package com.example.myapplication.machinecoding.foodDelivery.strategy;

import com.example.myapplication.machinecoding.foodDelivery.entities.DeliveryMetaData;

interface DeliveryChargeCalculationStrategy {
    public double calculateDeliveryCharge(DeliveryMetaData deliveryMetaData);
}

