package org.example.leetcode;

public class P572子树判断 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }
    public class Solution {
        public boolean isSubTree(TreeNode s, TreeNode t) {
            if (s == null) return false;
            if (isSame(s, t)) return true;

            return isSubTree(s.left, t) || isSubTree(s.right, t);
        }

        private boolean isSame(TreeNode s, TreeNode t) {
            if (s == null && t == null) return true;
            if (s == null || t == null) return false;
            if (s.val != t.val) return false;

            return isSame(s.left, t.left) && isSame(s.right, t.right);
        }
    }
}
