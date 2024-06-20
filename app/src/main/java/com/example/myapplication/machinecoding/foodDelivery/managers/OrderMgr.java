package com.example.myapplication.machinecoding.foodDelivery.managers;

import com.example.myapplication.machinecoding.foodDelivery.entities.DeliveryMetaData;
import com.example.myapplication.machinecoding.foodDelivery.notification.NotificationMgr;
import com.example.myapplication.machinecoding.foodDelivery.entities.Order;
import com.example.myapplication.machinecoding.foodDelivery.notification.SMSNotificationSender;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class OrderMgr {
    private static OrderMgr orderMgrInstance = null;
    private static final ReentrantLock mtx = new ReentrantLock();
    private DeliveryMgr deliveryMgr;
    private FoodMgr foodMgr;
    private Map<String, Order> ordersMap;

    private OrderMgr() {
        deliveryMgr = DeliveryMgr.getDeliveryMgr();
        foodMgr = FoodMgr.getFoodMgr();
        ordersMap = new HashMap<>();
        // Initialize deliveryMgr, foodMgr, and ordersMap here
    }

    public void addUserForNotificationUpdates(String pOrderId, Order pOrder) {
        NotificationMgr notificationMgr = NotificationMgr.getNotificationMgr();
        // we can add push or whatsapp notifications in same way. Basically, we are keeping all notifications customizable
        notificationMgr.addNotificationSender(pOrderId, pOrder.getUserId(), new SMSNotificationSender());
        // this configuration level should be in user class and not in order mgr
    }

    public void manageDelivery(String pOrderId, Order pOrder) {
        DeliveryMetaData metaData = new DeliveryMetaData(pOrderId, pOrder.getUserLocation(), pOrder.getRestaurantLocation());
        deliveryMgr.manageDelivery(pOrderId, metaData);
    }

    public void manageFood(String pOrderId, Order pOrder) {
        foodMgr.prepareFood(pOrderId, pOrder.getRestaurantId(), pOrder.getDishes());
    }

    public void createOrder(String pOrderId, Order pOrder) {
        addUserForNotificationUpdates(pOrderId, pOrder);
        manageFood(pOrderId, pOrder);
        manageDelivery(pOrderId, pOrder);
    }

    public static OrderMgr getOrderMgr() {
        if (orderMgrInstance == null) {
            mtx.lock();
            try {
                if (orderMgrInstance == null) {
                    orderMgrInstance = new OrderMgr();
                }
            } finally {
                mtx.unlock();
            }
        }
        return orderMgrInstance;
    }

    public Order getOrder(String pOrderName) {
        return ordersMap.get(pOrderName);
    }
}


