package com.example.myapplication.machinecoding.pollingSystem.dao.impl;

import com.example.myapplication.machinecoding.pollingSystem.dao.UserDao;

import java.util.HashMap;
import java.util.HashSet;

public class UserDaoImMemoryImpl implements UserDao {
//    private final HashMap<String, HashSet<String>> userStore = new HashMap<>(); //<userId, HashSet<PollId>>
    private final HashMap<String, HashSet<String>> userStore; //<userId, HashSet<PollId>>

    public UserDaoImMemoryImpl() {
        this.userStore = new HashMap<>();
    }


    @Override
    public synchronized HashMap<String, HashSet<String>> getUserVoteData() {
        return userStore;
    }
}
