package org.example.map;

import org.example.AVLTree.AVLTree;


public class AVLMap<K extends Comparable<K>, V> implements Map<K, V> {
    private AVLTree<K, V> avl;

    public AVLMap() {
        avl = new AVLTree<>();
    }

    @Override
    public int getSize() {
        return avl.size();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }

    @Override
    public boolean contains(K key) {
        return avl.contains(key);
    }

    @Override
    public void add(K key, V v) {
        avl.add(key, v);
    }

    @Override
    public V get(K key) {
        return avl.get(key);
    }

    @Override
    public void set(K key, V v) {
        avl.set(key, v);
    }

    @Override
    public V remove(K key) {
        return avl.remove(key);
    }
}
