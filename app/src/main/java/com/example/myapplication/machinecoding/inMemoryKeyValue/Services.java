package com.example.myapplication.machinecoding.inMemoryKeyValue;

import java.util.HashMap;

public class Services {
    Dao dao;

    public Services(Dao dao) {
        this.dao = dao;
    }

    public String put(String[] inputArray) {
        if (inputArray.length % 2 != 0) {
            return "In valid number of input words, input length = " + inputArray.length;
        }
        int length = inputArray.length;
        String key = inputArray[1];
        HashMap<String, Object> currMap = dao.getValueMap(key);
        for (int i = 2; i < length; i = i + 2) {
//            System.out.println("Key = " + inputArray[i] + " value = " + inputArray[i+1]);
            currMap.put(inputArray[i], inputArray[i + 1]);
        }
        dao.putKeyValue(key, currMap);
        return dao.getValueString(key);
    }

    public String get(String[] inputArray) {
        String key = inputArray[1];
        return dao.getValueString(key);
    }
}
