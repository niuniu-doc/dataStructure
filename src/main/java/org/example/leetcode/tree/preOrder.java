package org.example.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preOrder {
    /**
     * definition for a treeNode
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (){}
        TreeNode (int val) {
            this.val = val;
        }
        TreeNode (int val, TreeNode left, TreeNode right ){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Recursion
     * 时间复杂度和空间复杂度都是O(n)
     */
    class Solution {
        List<Integer> res = new ArrayList<>();
        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) return res;
            res.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            return res;
        }
    }

    /**
     * Traverse
     * 时间复杂度和空间复杂度都是O(n)
     */
    class Solution2 {
        public List<Integer> preorderTraversal(TreeNode root){
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                while(root != null){
                    stack.push(root);
                    result.add(root.val);
                    root=root.left;
                }
                root = stack.pop().right;
            }
            return result;
        }


    }
}
