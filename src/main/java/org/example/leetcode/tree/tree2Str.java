package org.example.leetcode.tree;

public class tree2Str {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {
        public String tree2Str(TreeNode root) {
            if (root == null) return "";
            if (root.left == null && root.right == null) return root.val + "";
            if (root.right == null) return root.val + "(" + tree2Str(root.left) + ")";
            return root.val + "(" + tree2Str(root.left) + ")(" + tree2Str(root.right) + ")";
        }
    }
}
