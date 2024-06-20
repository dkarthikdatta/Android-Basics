package com.example.myapplication.machinecoding.foodDelivery.managers;


import com.example.myapplication.machinecoding.foodDelivery.entities.DeliveryMetaData;
import com.example.myapplication.machinecoding.foodDelivery.entities.DeliveryPartner;
import com.example.myapplication.machinecoding.foodDelivery.strategy.IDeliveryPartnerMatchingStrategy;
import com.example.myapplication.machinecoding.foodDelivery.notification.NotificationMgr;
import com.example.myapplication.machinecoding.foodDelivery.notification.PushNotificationSender;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeliveryMgr {
    private static DeliveryMgr deliveryMgrInstance = null;
    private static final Lock mtx = new ReentrantLock();

    private DeliveryMgr() {
        // private constructor to prevent instantiation
    }

    public static DeliveryMgr getDeliveryMgr() {
        if (deliveryMgrInstance == null) {
            mtx.lock();
            try {
                if (deliveryMgrInstance == null) {
                    deliveryMgrInstance = new DeliveryMgr();
                }
            } finally {
                mtx.unlock();
            }
        }
        return deliveryMgrInstance;
    }

    // This function should be broken down into sub parts and every method should have one small responsibility
    public void manageDelivery(String pOrderId, DeliveryMetaData pDeliveryMetaData) {
        StrategyMgr strategyMgr = StrategyMgr.getStrategyMgr();

        IDeliveryPartnerMatchingStrategy partnerMatchingStrategy =
                strategyMgr.determineDeliveryPartnerMatchingStrategy(pDeliveryMetaData);

        List<DeliveryPartner> deliveryPartners =
                partnerMatchingStrategy.matchDeliveryPartners(pDeliveryMetaData);

        NotificationMgr notificationMgr = NotificationMgr.getNotificationMgr();
        // Send push notifications to the nearest delivery partners
        for (DeliveryPartner deliveryPartner : deliveryPartners) {
            notificationMgr.notifyParticularUser(deliveryPartner.getName(), "Delivery Request", new PushNotificationSender());
        }

        DeliveryPartner assignedDeliveryPartner = deliveryPartners.get(0);

        // Assume first delivery partner accepted it
        notificationMgr.notify(pOrderId, "Delivery Partner " + assignedDeliveryPartner.getName() + " assigned for the order " + pOrderId);

        performDelivery(assignedDeliveryPartner, pOrderId, pDeliveryMetaData);
    }

    // Order Status also needs to be updated while these steps are happening
    // We have black-boxed that
    private void performDelivery(DeliveryPartner assignedDeliveryPartner, String pOrderId, DeliveryMetaData pDeliveryMetaData) {
        NotificationMgr notificationMgr = NotificationMgr.getNotificationMgr();
        String name = assignedDeliveryPartner.getName();

        double restaurantLocLatitude = pDeliveryMetaData.getRestaurantLoc().getLatitude();
        double restaurantLocLongitude = pDeliveryMetaData.getRestaurantLoc().getLongitude();
        notificationMgr.notify(pOrderId, name + " going to pick up delivery from location "
                + Double.toString(restaurantLocLatitude) + "," + Double.toString(restaurantLocLongitude));

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        notificationMgr.notify(pOrderId, name + " picked up delivery!");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        notificationMgr.notify(pOrderId, name + " on the way to deliver!");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        double userLocLatitude = pDeliveryMetaData.getUserLoc().getLatitude();
        double userLocLongitude = pDeliveryMetaData.getUserLoc().getLongitude();
        notificationMgr.notify(pOrderId, name + " reached the location " + Double.toString(userLocLatitude) + "," + Double.toString(userLocLongitude));

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        notificationMgr.notify(pOrderId, name + " delivered the order. CONGRATULATIONS!!");
    }
}


