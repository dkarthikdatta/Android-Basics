package com.example.myapplication.machinecoding.foodDelivery.notification;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class NotificationMgr {
    private static NotificationMgr notificationMgrInstance = null;

    private static final ReentrantLock lock = new ReentrantLock();
    private INotificationSender notificationSender;

    private NotificationMgr() {
        notificationSender = new PushNotificationSender();
        // private constructor to prevent instantiation
    }

    public static NotificationMgr getNotificationMgr() {
        if (notificationMgrInstance == null) {
            lock.lock();
            try {
                if (notificationMgrInstance == null) {
                    notificationMgrInstance = new NotificationMgr();
                }
            } finally {
                lock.unlock();
            }
        }
        return notificationMgrInstance;
    }


    public void addNotificationSender(String pOrderId, String pRestaurantId, INotificationSender notificationSender) {

    }

    public void notify(String pOrderId, String customMsg) {
        notificationSender.sendNotification(pOrderId, customMsg);
    }

    public void notifyParticularUser(String name, String deliveryRequest, PushNotificationSender pushNotificationSender) {

    }
}


