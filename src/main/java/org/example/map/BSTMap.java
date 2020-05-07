package org.example.map;


public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
    private class Node {
        K key;
        V val;
        Node left;
        Node right;

        public Node(K k, V v) {
            this.key = k;
            this.val = v;
            left = null;
            right = null;
        }
    }

    private Node root; // 根节点
    private int size; // 节点数

    public BSTMap() {
        root = null;
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

    @Override
    public void add(K key, V v) {
        root = add(root, key, v);
    }

    private Node add(Node node, K k, V v) {
        if (node == null) {
            size++;
            return new Node(k, v);
        }

        if (k.compareTo(node.key) < 0 ){
            add(node.left, k, v);
        } else if (k.compareTo(node.key) > 0) {
            add(node.right, k, v);
        } else {
            // key.compareTo(node.key) == 0
            node.val = v;
        }

        return node;
    }

    private Node getNode(Node node, K k) {
        if (node == null) return  null;
        if (k.compareTo(node.key) == 0) {
            return node;
        } else if (k.compareTo(node.key) < 0) {
            return getNode(node.left, k);
        } else {
            return getNode(node.right, k);
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.val;
    }

    @Override
    public void set(K key, V v) {
        Node node = getNode(root, key);
        if (node == null) {
            System.out.println("error");
        }
        node.val = v;
    }

    private Node minimum(Node node) {
        if (node.left == null) return node;
        return minimum(node.left);
    }

    // 删除以node为根的二分搜索树的最小节点, 返回删除节点后新的二分搜索树
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.val;
        }
        return null;
    }

    private Node remove(Node node, K k) {
        if (node == null) return null;
        if (k.compareTo(node.key) < 0) {
            node.left = remove(node.left, k);
            return node;
        } else if (k.compareTo(node.key) > 0) {
            node.right = remove(node.right, k);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            } else {
                // node.left / right 都非空
                Node successor = minimum(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;

                node.left = node.right = null;
                return successor;
            }
        }
    }
}
