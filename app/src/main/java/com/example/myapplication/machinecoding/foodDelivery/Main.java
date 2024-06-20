package com.example.myapplication.machinecoding.foodDelivery;


import com.example.myapplication.machinecoding.foodDelivery.enums.CUISINE;
import com.example.myapplication.machinecoding.foodDelivery.entities.DeliveryPartner;
import com.example.myapplication.machinecoding.foodDelivery.entities.Dish;
import com.example.myapplication.machinecoding.foodDelivery.entities.DishAddOn;
import com.example.myapplication.machinecoding.foodDelivery.entities.Location;
import com.example.myapplication.machinecoding.foodDelivery.entities.Menu;
import com.example.myapplication.machinecoding.foodDelivery.entities.Order;
import com.example.myapplication.machinecoding.foodDelivery.entities.Restaurant;
import com.example.myapplication.machinecoding.foodDelivery.entities.RestaurantOwner;
import com.example.myapplication.machinecoding.foodDelivery.entities.User;
import com.example.myapplication.machinecoding.foodDelivery.managers.DeliveryPartnerMgr;
import com.example.myapplication.machinecoding.foodDelivery.managers.OrderMgr;
import com.example.myapplication.machinecoding.foodDelivery.managers.RestaurantMgr;
import com.example.myapplication.machinecoding.foodDelivery.managers.UserMgr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Chinese Restaurant
        RestaurantOwner owner1 = new RestaurantOwner("owner1");
        Restaurant chineseRest = new Restaurant("chinese vala", owner1, new Location(1, 2));
        Dish noodles = new Dish("noodles", CUISINE.CHINESE, 200);
        noodles.addAddOn(new DishAddOn("premium sauce", 20));
        Dish friedRice = new Dish("fried rice", CUISINE.CHINESE, 180);
        Dish springRolls = new Dish("spring rolls", CUISINE.CHINESE, 120);
        List<Dish> chineseDishes = new ArrayList<>(Arrays.asList(friedRice, springRolls, noodles));
        Menu chineseMenu = new Menu(chineseDishes);
        chineseRest.addMenu(chineseMenu);

        // South Indian Restaurant
        RestaurantOwner owner2 = new RestaurantOwner("owner2");
        Restaurant southIndianRest = new Restaurant("south indian food", owner2, new Location(2, 3));
        Dish idli = new Dish("idli", CUISINE.SOUTH_INDIAN, 200);
        Dish dosa = new Dish("dosa", CUISINE.SOUTH_INDIAN, 180);
        Dish uthappam = new Dish("uthappam", CUISINE.SOUTH_INDIAN, 120);
        List<Dish> southIndianDishes = new ArrayList<>(Arrays.asList(idli, dosa, uthappam));
        Menu southIndianMenu = new Menu(southIndianDishes);
        southIndianRest.addMenu(southIndianMenu);

        // Note that restaurant owners can exist without restaurants, we have used aggregation relationship
        // This can lead to owners being present with no restaurants and thus not added in restaurant manager
        // This is how we have designed and we should know consequences of the way we have structured.

        RestaurantMgr restaurantMgr = RestaurantMgr.getRestaurantMgr();
        restaurantMgr.addRestaurant("chinese vala", chineseRest);
        restaurantMgr.addRestaurant("south indian food", southIndianRest);

        //////////////////////////////////////////////////////////////////////////////////////////////////

        DeliveryPartner alpha = new DeliveryPartner("alpha");
        DeliveryPartner beta = new DeliveryPartner("beta");
        DeliveryPartner gamma = new DeliveryPartner("gamma");

        DeliveryPartnerMgr deliveryPartnerMgr = DeliveryPartnerMgr.getDeliveryPartnerMgr();
        deliveryPartnerMgr.addDeliveryPartner("alpha", alpha);
        deliveryPartnerMgr.addDeliveryPartner("beta", beta);
        deliveryPartnerMgr.addDeliveryPartner("gamma", gamma);

        //////////////////////////////////////////////////////////////////////////////////////////////////

        User keerti = new User("keerti", new Location(10, 11));
        User gaurav = new User("gaurav", new Location(13, 14));
        User yogita = new User("yogita", new Location(15, 16));
        // users can exist without usermgr as well. That's why it is an aggregation relationship

        UserMgr userMgr = UserMgr.getUserMgr();
        userMgr.addUser("keerti", keerti);
        userMgr.addUser("gaurav", gaurav);
        userMgr.addUser("yogita", yogita);

        //////////////////////////////////////////////////////////////////////////////////////////////////

        // I am passing same dish object that was created by res, for C++ folks - it should be different dish object

        Map<Dish, Integer> cart = new HashMap<>();
        cart.put(noodles, 2);
        cart.put(friedRice, 1);
        Order order1 = new Order(keerti, chineseRest, cart);

        OrderMgr orderMgr = OrderMgr.getOrderMgr();
        orderMgr.createOrder("order1", order1); // Ideally, the id should be created in order manager when order is created
        // This is just for simplicity purposes and has been mentioned in the class as well
        // We have done same for all ids - user, restaurant, delivery partner etc.

        return;
    }
}


