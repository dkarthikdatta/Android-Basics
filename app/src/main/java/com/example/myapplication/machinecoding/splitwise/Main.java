package com.example.myapplication.machinecoding.splitwise;

import com.example.myapplication.machinecoding.splitwise.dao.Dao;
import com.example.myapplication.machinecoding.splitwise.dao.IDao;
import com.example.myapplication.machinecoding.splitwise.models.User;
import com.example.myapplication.machinecoding.splitwise.services.SplitServices;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static IDao dao = new Dao();
    static SplitServices services = new SplitServices(dao);

    public static void main(String[] args) {

        // payingUserid, no of ppl in expense, listOfUsers, SplitType, space-separated-values-in-case-of-non-equal
        int payeeUserId;
        ArrayList<Integer> listOfUserIdInExpense;
        SplitType type;
        ArrayList<Double> percent;
        double amount;
        ArrayList<Double> exactSplitValues;

        User user1 = new User(0, "Kar", "kart@123", "1243");
        User user2 = new User(1, "Din", "Din@123", "1243");
        User user3 = new User(2, "Rah", "Rah@123", "1243");
        User user4 = new User(3, "Vis", "Vis@123", "1243");

        services.createAccount(user1);
        services.createAccount(user2);
        services.createAccount(user3);
        services.createAccount(user4);
        ArrayList<Integer> users = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        String feedback = services.split(1000, 1, users, SplitType.EQUAL, null, null);
        System.out.println(feedback);

        services.showOverView();
    }


}
