package com.example.myapplication.machinecoding.customCache;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        DataStore<String, String> inMemoryDataStore = new InMemoryStore<>();
        EvictionPolicy<String> evictionPolicy = new RandomEvictionPolicy<>();
        int boundedSize = 2;
        CacheStore<String, String> cacheStore = new CacheStore(inMemoryDataStore, evictionPolicy, boundedSize);

        System.out.println("[put] Putting key1,value1");
        cacheStore.put("key1", "value1");
        System.out.println("[put] Putting key2,value2");
        cacheStore.put("key2", "value2");
        System.out.println("[get] Getting key1");
        System.out.println(cacheStore.get("key1"));
        System.out.println("[put] Putting key3,value3");
    }
}
