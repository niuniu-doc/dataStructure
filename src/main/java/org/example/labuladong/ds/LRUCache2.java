package org.example.labuladong.ds;

import java.util.HashMap;

public class LRUCache2 {
    static class Node {
        int key, val;
        Node pre, next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    static class DoubleList {
        Node head, tail;
        int size;
        DoubleList() {
            size = 0;
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
        }

        public void addFirst(Node x) {
            x.pre = head;
            x.next = tail;
            head.next.pre = x;
            head.next = x;
            size ++;
        }

        public void remove(Node x) {
            // 移除节点
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

    private  final DoubleList cache;
    private  final HashMap<Integer, Node> map;
    private  final int cap;
    LRUCache2(int cap) {
        this.cap = cap;
        map = new HashMap<>(cap);
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        int val = map.get(key).val;
        put(key, val);
        return val;
    }

    public void put(int key, int val) {
        // 若key在cache中存在、先删除, 若cache已满、先删除最后一次访问的元素
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
        } else {
            if (cache.size == cap) {
                Node x = cache.removeLast();
                map.remove(x.key);
            }
        }
        Node x = new Node(key, val);
        cache.addFirst(x);
        map.put(key, x);
    }

    public static void main(String[] args) {
        LRUCache2 cache2 = new LRUCache2(2);
        cache2.put(1, 2);
        cache2.put(2, 3);
        cache2.put(1, 2);
        cache2.put(1,3);
        cache2.put(1,4);
        System.out.println(cache2.get(2));
        System.out.println(cache2.get(1));
    }
}
