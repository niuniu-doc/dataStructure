package org.example.RedBlackTree;

import com.sun.org.apache.regexp.internal.RE;
import org.example.map.Map;

public class RBTree<K extends Comparable<K>, V> implements Map<K, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private class Node {
        K key;
        V val;
        Node left;
        Node right;
        public boolean color;

        public Node(K k, V v) {
            this.key = k;
            this.val = v;
            left = null;
            right = null;
            color = RED;
        }
    }

    private Node root; // 根节点
    private int size; // 节点数

    public RBTree() {
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

    private boolean isRed(Node node) {
        if (node == null) return BLACK;
        return node.color;
    }

    private Node leftRotate(Node node) {
        Node x = node.right;

        // 左旋转
        node.right = x.left;
        x.left = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }

    private Node rightRotate(Node node) {
        Node x = node.left;

        // 右旋转
        node.left = x.right;
        x.right = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }

    // 颜色翻转
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    @Override
    public void add(K key, V v) {
        root = add(root, key, v);
        root.color = BLACK; // 根节点为黑色
    }

    private Node add(Node node, K k, V v) {
        if (node == null) {
            size++;
            return new Node(k, v);
        }

        if (k.compareTo(node.key) < 0) {
            add(node.left, k, v);
        } else if (k.compareTo(node.key) > 0) {
            add(node.right, k, v);
        } else {
            // key.compareTo(node.key) == 0
            node.val = v;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }

        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }

        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    private Node getNode(Node node, K k) {
        if (node == null) return null;
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
            size--;
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