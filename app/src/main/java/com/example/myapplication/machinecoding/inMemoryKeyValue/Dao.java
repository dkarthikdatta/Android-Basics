package com.example.myapplication.machinecoding.inMemoryKeyValue;

import java.util.HashMap;

public class Dao implements IDao {
    private KeyValue keyValue;

    public Dao() {
        this.keyValue = new KeyValue(new HashMap<>());
    }


    @Override
    public void putKeyValue(String key, HashMap<String, Object> value) {
        keyValue.getHashMap().put(key, value);
    }

    @Override
    public String getValueString(String key) {
        return keyValue.getValueString(key);
    }

    @Override
    public HashMap<String, Object> getValueMap(String key) {
        if (keyValue.getHashMap().get(key) != null) {
            return keyValue.getHashMap().get(key);
        }
        return new HashMap<>();
    }
}
