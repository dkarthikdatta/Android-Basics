package com.example.myapplication.machinecoding.inMemoryKeyValue;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

public class KeyValue {
    HashMap<String, HashMap<String, Object>> hashMap;

    public KeyValue(HashMap<String, HashMap<String, Object>> hashMap) {
        this.hashMap = hashMap;
    }

    public void setHashMap(HashMap<String, HashMap<String, Object>> hashMap) {
        this.hashMap = hashMap;
    }

    public HashMap<String, HashMap<String, Object>> getHashMap() {
        return hashMap;
    }

    public String getValueString(String key) {
        HashMap<String, Object> currMap = hashMap.get(key);
        StringBuilder stringBuilder = new StringBuilder();
//        System.out.println("getValueString, Key = " + key);
        if (currMap != null) {
            for (Map.Entry<String, Object> entrySet : currMap.entrySet()) {
                stringBuilder.append(entrySet.getKey()).append(": ").append(entrySet.getValue()).append(", ");
            }
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
            return stringBuilder.toString();
        }
        return "";
    }

}
