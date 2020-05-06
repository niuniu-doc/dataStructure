package org.example.map;

public class LinkedListMap<K, V> implements Map<K, V> {
    private class Node {
        public K key;
        public V val;
        public Node next;

        public Node(K key, V val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key))
                return cur;
            cur = cur.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.val;
    }

    @Override
    public void add(K key, V v) {
        Node node = getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, v, dummyHead.next);
            size++;
        } else {
            node.val = v; // 更新为新的值
        }
    }

    @Override
    public void set(K key, V v) {
        Node node = getNode(key);
        if (node == null)
            System.out.println("exists");
        node.val = v; // 若key存在、更新key的值
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        // 找到要删除的节点
        while (prev.next != null) {
            if (prev.next.key.equals(key)) break;
            prev = prev.next;
        }

        // 若节点不为空、将节点删除, 否则直接返回null即可
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.val;
        }

        return null;
    }
}
