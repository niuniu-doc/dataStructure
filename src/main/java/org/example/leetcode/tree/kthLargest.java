package org.example.leetcode.tree;

public class kthLargest {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode (){}
        public TreeNode (int val) { this.val = val; }
        public TreeNode (int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        /**
         * if inOrder iteration, data ordered from small to large, we inverse it .
         * @param root
         * @param k
         * @return
         */
        int res, k;
        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            inOrder(root);
            return res;
        }

        public void  inOrder(TreeNode root) {
            if (root == null) return;
            inOrder(root.right);
            if (--k == 0) res = root.val;
            inOrder(root.left);
        }
    }
}
