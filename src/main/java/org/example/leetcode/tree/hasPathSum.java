package org.example.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class hasPathSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){}
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
        public boolean hasPathSum(TreeNode root, int targetSum) {
//            /**
//             * recur: hasPathSum(target-val)
//             */
//            if (root == null) return false;
//            if (root.left == null && root.right == null) return targetSum == root.val;
//
//            return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum- root.val);

            /**
             * use bfs, use two queue,
             * one store treeNode val, other store sum from root to this node
             */
            if (root == null) return false;

            Queue<TreeNode> queNode = new LinkedList<TreeNode>();
            Queue<Integer> queVal = new LinkedList<>();
            queNode.offer(root);
            queVal.offer(root.val);

            while (!queNode.isEmpty()) {
                TreeNode cur = queNode.poll();
                int tmp = queVal.poll();

                if (cur.left == null && cur.right == null) {
                    if (tmp == targetSum) return true;
                    continue;
                }

                if (cur.left != null) {
                    queNode.offer(cur.left);
                    queVal.offer(cur.left.val + tmp);
                }
                if (cur.right != null) {
                    queNode.offer(cur.right);
                    queVal.offer(cur.right.val + tmp);
                }
            }
            return false;
        }
    }
}
