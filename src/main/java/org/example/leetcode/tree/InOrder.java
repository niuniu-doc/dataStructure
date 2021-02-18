package org.example.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {
    /**
     * definition treeNode
     */
    class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode () {}
        TreeNode (int val){
            this.val = val;
        }
        TreeNode (int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Recursion
     */

    class Solution {
        List<Integer> result = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root){
            if (root == null) return result;
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);
            return result;
        }
    }

    /**
     * traverse
     */
    class Solution2{
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();

            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }

                TreeNode pop = stack.pop();
                result.add(pop.val);
                root = pop.right;
            }
            return result;
        }



    }
}
