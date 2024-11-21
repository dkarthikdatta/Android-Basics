package com.example.myapplication.dsAlgo.ds.Hash;

import com.example.myapplication.inheritance.P;

import java.util.HashMap;

public class LRUCache {

    /**
     * Use HashMap -> O(1) insert and get
     * Doubly Linked list ->O(1) -> to change position of the element in O(1)
     */


    static class DLLNode {
        DLLNode prev;
        DLLNode next;

        int key;
        int value;

        DLLNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity = 0;
    DLLNode head = new DLLNode(0,0);
    DLLNode tail = new DLLNode(0,0);

    HashMap<Integer, DLLNode> hm;
    public static void main(String[] args) {

    }

    private void LRUCacheInit(int capacity){
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        hm = new HashMap<>();
    }

    private void insert(int key, int val){
        if(hm.containsKey(key)){
            removeDLLNode(hm.get(key));
        } else {
            if(hm.size() == capacity){
                removeDLLNode(tail.prev);
            }
        }
        insertFront(new DLLNode(key, val));
    }

    private int get(int key) {
        if (hm.containsKey(key)){
            DLLNode dllNode = hm.get(key);
            removeDLLNode(dllNode);
            insertFront(dllNode);
            return dllNode.value;
        }
        return -1;
    }

    private void insertFront(DLLNode dllNode) {
        hm.put(dllNode.key, dllNode);

        DLLNode initialHeadNext = head.next;

        head.next = dllNode;
        dllNode.prev = head;
        dllNode.next = initialHeadNext;
        initialHeadNext.prev = dllNode;
    }



    private void removeDLLNode(DLLNode node){
        hm.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


}
