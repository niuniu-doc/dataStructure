package org.example.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {
        List<Integer> res = new ArrayList<>();
        public List<Integer> postInorder(TreeNode root) {
            if (root == null) return res;
            postInorder(root.left);
            postInorder(root.right);
            res.add(root.val);
            return res;
        }
    }

    class Solution2 {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        public List<Integer> postInorder(TreeNode root){
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                TreeNode pop = stack.pop();
                if (pop == null || pop.right == prev) {
                    res.add(pop.val);
                    prev = pop;
                    root = null;
                } else {
                    stack.push(pop);
                    pop = pop.right;
                }
            }
            return res;
        }
    }
}
