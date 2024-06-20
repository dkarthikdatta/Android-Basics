package com.example.myapplication.machinecoding.customCache;

import java.util.Objects;

public class CacheStore<K, V> {

    DataStore<K, V> dataStore;
    EvictionPolicy<K> evictionPolicy;
    int boundedSize = 0;


    public CacheStore(DataStore<K, V> dataStore, EvictionPolicy<K> evictionPolicy, int boundedSize) {
        this.dataStore = dataStore;
        this.evictionPolicy = evictionPolicy;
        this.boundedSize = boundedSize;
    }

    public V get(K key) {
        V value = dataStore.get(key);
        this.evictionPolicy.onGetOperation(key);
        return value;
    }

    public void put(K key, V value) {
        if (this.dataStore.keyExists(key)) {
            this.evictionPolicy.onPutOperation(key);
            this.dataStore.put(key, value);
            return;
        }
        if (Objects.equals(this.dataStore.getStoreSize(), boundedSize)) {
            K evictKey = this.evictionPolicy.getEvictionKey();
            this.dataStore.delete(evictKey);
            System.out.println("[evict] Evicting key: " + evictKey);
        }
        this.dataStore.put(key, value);
        this.evictionPolicy.onPutOperation(key);
    }
}
