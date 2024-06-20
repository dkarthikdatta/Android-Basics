package com.example.myapplication.machinecoding.foodDelivery.managers;

import com.example.myapplication.machinecoding.foodDelivery.entities.DeliveryPartner;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class DeliveryPartnerMgr {
    private static DeliveryPartnerMgr deliveryPartnerMgrInstance = null;
    private static ReentrantLock mtx = new ReentrantLock();
    private ConcurrentHashMap<String, DeliveryPartner> deliveryPartnersMap = new ConcurrentHashMap<>();

    private DeliveryPartnerMgr() {
        // private constructor to prevent instantiation
    }

    public static DeliveryPartnerMgr getDeliveryPartnerMgr() {
        if (deliveryPartnerMgrInstance == null) {
            mtx.lock();
            try {
                if (deliveryPartnerMgrInstance == null) {
                    deliveryPartnerMgrInstance = new DeliveryPartnerMgr();
                }
            } finally {
                mtx.unlock();
            }
        }
        return deliveryPartnerMgrInstance;
    }

    public void addDeliveryPartner(String pDeliveryPartnerName, DeliveryPartner pDeliveryPartner) {
        deliveryPartnersMap.put(pDeliveryPartnerName, pDeliveryPartner);
    }

    public DeliveryPartner getDeliveryPartner(String pDeliveryPartnerName) {
        return deliveryPartnersMap.get(pDeliveryPartnerName);
    }

    public Map<String,
            DeliveryPartner> getDeliveryPartnersMap() {
        return deliveryPartnersMap;
    }
}

