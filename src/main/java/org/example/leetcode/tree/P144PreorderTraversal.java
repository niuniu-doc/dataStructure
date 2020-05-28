package org.example.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P144PreorderTraversal {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            // 方法一: 递归解法
//            List<Integer> res = new ArrayList<>();
//            helper(root, res);
//            return res;

            // 方法二: 非递归解法
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (root!=null || !stack.isEmpty()) {
                while (cur!=null) {
                    res.add(cur.val);
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop().right;
            }
            return res;
        }

        private void helper(TreeNode root, List<Integer> res) {
            if (root == null) return;
            res.add(root.val);
            if (root.left != null) helper(root.left, res);
            if (root.right != null) helper(root.right, res);
        }

    }
}
