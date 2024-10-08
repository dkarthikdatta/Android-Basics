package com.example.myapplication.machinecoding.pollingSystem.dao;

import java.util.HashMap;
import java.util.HashSet;

public interface UserDao {
    HashMap<String, HashSet<String>> getUserVoteData(); //<userId, HashSet<pollId>>
}
