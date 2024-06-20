package com.example.myapplication.machinecoding.foodDelivery.strategy;

import com.example.myapplication.machinecoding.foodDelivery.entities.DeliveryMetaData;
import com.example.myapplication.machinecoding.foodDelivery.entities.DeliveryPartner;

import java.util.List;

public interface IDeliveryPartnerMatchingStrategy {
    List<DeliveryPartner> matchDeliveryPartners(DeliveryMetaData pDeliveryMetaData);
}


