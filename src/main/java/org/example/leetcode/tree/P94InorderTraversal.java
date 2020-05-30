package org.example.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P94InorderTraversal {
    class TreeNode {
        int val; // 保存节点值
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    // 二叉树中序遍历
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
//            // 方法一: 递归
//            List<Integer> res = new ArrayList<>();
//            helper(root, res);
//            return res;

            // 方法二: 使用栈
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur!= null || !stack.isEmpty()) {
                // 若栈非空 或者 节点未全部遍历完成
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
            return res;
        }

        private void helper(TreeNode root, List<Integer> res) {
            if (root == null) return;
            if (root.left != null) helper(root.left, res);
            res.add(root.val);
            if (root.right != null) helper(root.right, res);
        }
    }
}
