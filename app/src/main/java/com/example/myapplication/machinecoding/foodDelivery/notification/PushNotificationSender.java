package com.example.myapplication.machinecoding.foodDelivery.notification;

import com.example.myapplication.machinecoding.foodDelivery.notification.INotificationSender;

public class PushNotificationSender implements INotificationSender {
    @Override
    public void sendNotification(String pUserId, String pMsg) {
        System.out.println("Push Notification for " + pUserId + " is " + pMsg);
    }
}


