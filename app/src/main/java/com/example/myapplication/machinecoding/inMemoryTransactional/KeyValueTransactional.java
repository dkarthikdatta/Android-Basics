package com.example.myapplication.machinecoding.inMemoryTransactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class KeyValueStore {
    private Map<String, String> store;
    private Stack<Transaction> transactionStack;

    public KeyValueStore() {
        this.store = new HashMap<>();
        this.transactionStack = new Stack<>();
    }

    public String get(String key) {
        return this.store.get(key);
    }

    public void set(String key, String value) {
        this.trackChange(key);
        this.store.put(key, value);
    }

    public void delete(String key) {
        this.trackChange(key);
        this.store.remove(key);
    }

    private void trackChange(String key) {
        if (!this.transactionStack.isEmpty()) {
            Transaction transaction = this.transactionStack.peek();
            if (!transaction.changes.containsKey(key)) {
                // Keep track of original value for rollback purposes
                transaction.changes.put(key, this.store.getOrDefault(key, null));
            }
        }
    }

    public long beginTransaction() {
        Transaction transaction = new Transaction(System.currentTimeMillis());
        this.transactionStack.push(transaction);
        return transaction.id;
    }

    public void commitTransaction(long transactionId) {
        int transactionIndex = findTransactionIndex(transactionId);
        if (transactionIndex != -1) {
            // All changes in transaction are already applied to the store
            this.transactionStack.setSize(transactionIndex);
        } else {
            throw new IllegalArgumentException("Transaction with ID " + transactionId + " not found");
        }
    }

    public void rollbackTransaction(long transactionId) {
        int transactionIndex = findTransactionIndex(transactionId);
        if (transactionIndex != -1) {
            // Rollback changes
            Transaction transaction = this.transactionStack.get(transactionIndex);
            for (Map.Entry<String, String> entry : transaction.changes.entrySet()) {
                if (entry.getValue() == null) {
                    this.store.remove(entry.getKey());
                } else {
                    this.store.put(entry.getKey(), entry.getValue());
                }
            }
            this.transactionStack.setSize(transactionIndex);
        } else {
            throw new IllegalArgumentException("Transaction with ID " + transactionId + " not found");
        }
    }

    private int findTransactionIndex(long transactionId) {
        for (int i = 0; i < this.transactionStack.size(); i++) {
            if (this.transactionStack.get(i).id == transactionId) {
                return i;
            }
        }
        return -1;
    }

    private static class Transaction {
        long id;
        Map<String, String> changes;

        Transaction(long id) {
            this.id = id;
            this.changes = new HashMap<>();
        }
    }
}


