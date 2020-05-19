package org.example.hashtable;

import java.util.Hashtable;
import java.util.TreeMap;

public class HashTable<K, V> {
    private TreeMap<K, V>[] hashTable;
    private int M;
    private int size;

    public HashTable(int M) {
        this.M = M;
        size = 0;
        hashTable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(97);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

    public void add(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;
        }
    }

    public V remove(K key) {
        TreeMap<K, V> map = hashTable[hash(key)];
        V ret = null;
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;
        }

        return ret;
    }

    public void set(K key, V val) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (!map.containsKey(key)) {
            System.out.println("not contains");
        }

        map.put(key, val);
    }

    public boolean contains(K key) {
        return hashTable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return hashTable[hash(key)].get(key);
    }

    private void resize(int newM) {
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < M; i++) {
            newHashTable[i] = new TreeMap<>();
        }

        this.M = newM;
        for (int i = 0; i < M; i++) {
            TreeMap<K, V> map = hashTable[i];
            for (K key : map.keySet()) {
                newHashTable[hash(key)].put(key, map.get(key));
            }
        }
    }
}
