package com.example.myapplication.machinecoding.customCache;

import java.util.HashMap;

public class InMemoryStore<K, V> implements DataStore<K, V> {
    HashMap<K, V> hashMap;

    public InMemoryStore() {
        this.hashMap = new HashMap<>();
    }

    @Override
    public void put(Object key, Object value) {

    }

    @Override
    public V get(Object key) {
        return hashMap.get(key);
    }

    @Override
    public void delete(Object key) {

    }


    @Override
    public boolean keyExists(K key) {
        return this.hashMap.containsKey(key);
    }

    @Override
    public int getStoreSize() {
        return this.hashMap.size();
    }


}
