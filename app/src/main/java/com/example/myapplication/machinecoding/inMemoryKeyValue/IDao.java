package com.example.myapplication.machinecoding.inMemoryKeyValue;

import java.util.HashMap;

public interface IDao {
    void putKeyValue(String key, HashMap<String, Object> value);

    HashMap<String, Object> getValueMap(String key);

    String getValueString(String key);
}
