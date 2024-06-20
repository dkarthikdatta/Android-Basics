package com.example.myapplication.machinecoding.foodDelivery.strategy;

import com.example.myapplication.machinecoding.foodDelivery.entities.DeliveryMetaData;
import com.example.myapplication.machinecoding.foodDelivery.entities.DeliveryPartner;
import com.example.myapplication.machinecoding.foodDelivery.managers.DeliveryPartnerMgr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LocBasedDeliveryPartnerMatchingStrategy implements IDeliveryPartnerMatchingStrategy {
    @Override
    public List<DeliveryPartner> matchDeliveryPartners(DeliveryMetaData pMetaData) {
        DeliveryPartnerMgr deliveryPartnerMgr = DeliveryPartnerMgr.getDeliveryPartnerMgr();

        System.out.println("Quadtrees can be used to get nearest delivery partners, " +
                "Delivery partner manager can be used to get details of partners. " +
                "Returning all delivery partners for demo purposes for now.");

        List<DeliveryPartner> nearestDeliveryPartners = new ArrayList<>();
        for (Map.Entry<String, DeliveryPartner> deliveryPartnerDetails : deliveryPartnerMgr.getDeliveryPartnersMap().entrySet()) {
            nearestDeliveryPartners.add(deliveryPartnerDetails.getValue());
        }
        return nearestDeliveryPartners;
    }
}


