package com.example.myapplication.machinecoding.foodDelivery.managers;

import com.example.myapplication.machinecoding.foodDelivery.entities.Dish;
import com.example.myapplication.machinecoding.foodDelivery.notification.NotificationMgr;
import com.example.myapplication.machinecoding.foodDelivery.notification.PushNotificationSender;
import com.example.myapplication.machinecoding.foodDelivery.entities.Restaurant;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FoodMgr {
    private static FoodMgr foodMgrInstance = null;
    private static final Lock mtx = new ReentrantLock();

    private FoodMgr() {
    }

    public static FoodMgr getFoodMgr() {
        if (foodMgrInstance == null) {
            mtx.lock();
            try {
                if (foodMgrInstance == null) {
                    foodMgrInstance = new FoodMgr();
                }
            } finally {
                mtx.unlock();
            }
        }
        return foodMgrInstance;
    }

    public void addRestaurantForNotificationUpdates(String pOrderId, String pRestaurantId) {
        NotificationMgr notificationMgr = NotificationMgr.getNotificationMgr();
        // we can add push or whatsapp notifications in same way. Basically, we are keeping all notifications customisable
        notificationMgr.addNotificationSender(pOrderId, pRestaurantId, new PushNotificationSender());
    }

    public void prepareFood(String pOrderId, String pRestaurantId, Map<Dish, Integer> pDishes) {
        RestaurantMgr restaurantMgr = RestaurantMgr.getRestaurantMgr();
        Restaurant restaurant = restaurantMgr.getRestaurant(pRestaurantId);
        prepareFoodInRestaurant(restaurant, pOrderId, pDishes);

        // Restaurant should receive the delivery partner's notifications.
        // The order in which the restaurant, user & delivery partner are added to the notification mgr
        // will decide which notifications they receive
        // For interviews, This is too much detailing though, we can just mention to interviewer and move forward
        addRestaurantForNotificationUpdates(pOrderId, pRestaurantId);
    }

    private boolean prepareFoodInRestaurant(Restaurant restaurant, String pOrderId, Map<Dish, Integer> dishes) {
        System.out.println("Restaurant, " + restaurant.getId() + " accepting the order and starting to prepare it");

        NotificationMgr notificationMgr = NotificationMgr.getNotificationMgr();

        notificationMgr.notify(pOrderId, "Food is being prepared in restaurant");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }

        notificationMgr.notify(pOrderId, "Food is ready and can be picked up from restaurant");

        return true;
    }
}


