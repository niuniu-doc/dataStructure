package org.example.bst;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
    // 二分搜索树必须具备可比较性

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
//        if (root == null) {
//            root = new Node(e);
//        } else {
//            add(root, e);
//        }
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0 ) {
            node.right = add(node.right, e);
        }

        return node;
    }

//    private void add(Node node, E e) {
//        if (e.compareTo(node.e) == 0) {
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//
//        if (e.compareTo(node.e) < 0 ) {
//            add(node.left, e);
//        } else {
//            add(node.right, e);
//        }
//    }

    // 查看二分搜索树种是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);
    }
    private boolean contains(Node node, E e) {
        if (node == null)
            return false;
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    // 遍历二分搜索树
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null)return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    // 前序遍历的非递归实现
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
    }

    // 二分搜索树的层序遍历
    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);

            if (cur.left != null) q.add(cur.left);
            if (cur.right != null) q.add(cur.right);
        }
    }

    // 查找二分搜索树的最小元素
    public E minimum() {
        if (size == 0) {
            System.out.println("error.");
        }
        return minimun(root).e;
    }

    private Node minimun(Node node) {
        if (node.left == null)
            return node;
        return minimun(node.left);
    }

    public E minumumNR() {
        if (size == 0) {
            System.out.println("error");
        }

        while (root.left != null) {
            root = root.left;
        }
        return root.e;
    }

    // 查找二分搜索树的最大值
    public E maxmium() {
        if (size == 0) {
            System.out.println("error");
        }
        return maxmium(root).e;
    }

    private Node maxmium(Node node) {
        if (node.right == null)
            return node;
        return maxmium(node.right);
    }

    // 删除二分搜索树的最大值
    public E removeMin() {
        E ret = minimum();

        root = removeMin(root);

        return ret;
    }

    // 删除掉以node为根的二分搜索树的最小节点, 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right; // 先将要删除的节点的右子树保持
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    // 删除以node为根的二分搜索树中值为e的节点, 返回删除节点后新的二分搜索树的根
    private Node remove(Node node, E e) {
        if (node == null) return null;
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
        } else { // e == node.e
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
                Node successor = minimun(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;

                node.left = node.right = null;
                return successor;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth+1, res);
        generateBSTString(node.right, depth+1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums)
            bst.add(num);

        bst.preOrder();
        System.out.println("\n");
        bst.preOrderNR();
//        System.out.println(bst.toString());
        System.out.println("\n");
        bst.levelOrder();
    }
}
