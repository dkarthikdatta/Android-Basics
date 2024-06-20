package com.example.myapplication.machinecoding.customCache;

public interface EvictionPolicy<K> {
    void onPutOperation(K key);
    void onGetOperation(K key);
    void onDeleteOperation(K key);
    K getEvictionKey();
}
