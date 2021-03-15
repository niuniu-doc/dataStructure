package org.example.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class IncreasingBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){}
        public TreeNode (int val) { this.val = val;}
        public TreeNode (int val, TreeNode left, TreeNode right ){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = generate(new Integer[] { 5, null, 6, null, 8, 7, 9 });
        new Solution2().increasingBST(treeNode);
    }
    public static TreeNode generate(Integer[] a) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(a[0]);
        queue.add(root);
        for (int i=0; i< a.length; i+=2) {
            TreeNode treeNode = queue.remove();
            if (a[i] != null) {
                treeNode.left =new TreeNode(a[i]);
                queue.add(treeNode.left);
            }
            if (i + 1 < a.length && a[i + 1] != null) {
                treeNode.right = new TreeNode(a[i + 1]);
                queue.add(treeNode.right);
            }
        }
        return root;
    }

    class Solution {
        /**
         * first inorder iteration, get an ordered array
         * then make a tree
         */
        public TreeNode increasingBST(TreeNode root) {
            List<Integer> vals = new ArrayList<>();
            inOrder(root, vals);
            TreeNode ans = new TreeNode(0), cur = ans;
            for (int v : vals) {
                cur.right = new TreeNode(v);
                cur = cur.right;
            }
            return ans;
        }

        public void inOrder(TreeNode root, List<Integer> vals) {
            if (root == null) return;
            inOrder(root.left, vals);
            vals.add(root.val);
            inOrder(root.right, vals);
        }
    }

    static class Solution2 {
        TreeNode cur;
        public TreeNode increasingBST(TreeNode root) {
            TreeNode ans = new TreeNode(0);
            cur = ans;
            inorder(root);
            return ans.right;
        }

        public void inorder(TreeNode node) {
            if (node == null) return;
            inorder(node.left);
            node.left = null;
            cur.right = node;
            cur = node;
            inorder(node.right);
        }
    }
}
