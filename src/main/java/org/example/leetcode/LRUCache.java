package org.example.leetcode;

import java.util.HashMap;

public class LRUCache {
    class Node {
        public int key, val;
        public Node next, prev;
        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    class DoubleList {
        private Node head, tail;
        private int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        // 在链表中添加头结点
        public void addFirst(Node x) {
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
            size++;
        }

        // 删除链表中的节点
        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        // 删除链表中最后一个节点, 并返回该节点
        public Node removeLast() {
            if (tail.prev == head) return null;
            Node last = tail.prev;
            remove(last);
            return last;
        }

        // 返回链表长度
        public int size() {
            return size;
        }
    }

    // LRUCache实现
    HashMap<Integer, Node> map; // 将key映射到 Node(key, val)
    DoubleList cache;
    private int cap; // 最大容量
    public LRUCache(int cap) {
        this.cap = cap;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    int get (int key) {
        if (!map.containsKey(key)) return -1; // key不存在
        int val = map.get(key).val;
        put(key, val);
        return val;
    }
    public void put(int key, int val) {
        Node x = new Node(key, val); // node
        if (map.containsKey(key)) {
            cache.remove(map.get(key)); // 删除旧的节点
        } else {
            // 若链表满、先删除链表最后一个数据
            if (cap == cache.size) {
                Node last = cache.removeLast();
                map.remove(last.key); // 删除map中的key
            }
            // 否则、直接添加到链表和map中
        }
        cache.addFirst(x);
        map.put(key, x); // 更新map中对应的数据
    }

    public static void main(String[] args) {
        org.example.labuladong.ds.LRUCache cache = new org.example.labuladong.ds.LRUCache(10);
        cache.put(1, 2);
        cache.put(2, 3);
        cache.put(1, 3);
        cache.put(1, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}



















