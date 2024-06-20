package com.example.myapplication.machinecoding.customCache;

import java.util.HashSet;
import java.util.Set;

public class RandomEvictionPolicy<K> implements EvictionPolicy<K> {
    Set<K> stringSet;

    public RandomEvictionPolicy() {
        this.stringSet = new HashSet<>();
    }

    @Override
    public void onPutOperation(K key) {

    }

    @Override
    public void onGetOperation(K key) {

    }

    @Override
    public void onDeleteOperation(K key) {

    }

    @Override
    public K getEvictionKey() {
        K val =  stringSet.iterator().next();
        stringSet.remove(val);
        return val;
    }
}
