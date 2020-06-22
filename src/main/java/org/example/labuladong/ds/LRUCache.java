package org.example.labuladong.ds;

import java.util.HashMap;

public class LRUCache {
    static class Node {
        int key, val;
        Node next, pre;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    static class DoubleList {
        Node head, tail;
        int size;
        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        public void addFirst(Node x) {
            x.next = head.next;
            x.pre = head;
            head.next.pre = x;
            head.next = x;
            size++;
        }

        // 节点一定存在
        public void remove(Node x) {
            x.next.pre = x.pre;
            x.pre.next = x.next;
            size--;
        }

        public Node removeLast() {
            if (tail.pre == head) return null;
            Node last = tail.pre;
            remove(last);
            return last;
        }
    }

    private final HashMap<Integer, Node> map;
    private final DoubleList cache;
    private final int cap;
    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new DoubleList();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1; // key不存在
        int val = map.get(key).val;
        put(key, val);
        return val;
    }

    public void put(int k, int v) {
        // 若key已存在、先删除
        if (map.containsKey(k)) {
            cache.remove(map.get(k));
        } else {
            // 若list已满, 先删除最后访问的节点
            if (cache.size == cap) {
                Node x = cache.removeLast();
                map.remove(x.key);
            }
        }
        Node x = new Node(k, v);
        cache.addFirst(x);
        map.put(k, x);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(10);
        cache.put(1, 2);
        cache.put(2, 3);
        cache.put(1, 3);
        cache.put(1, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
