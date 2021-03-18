package org.example.leetcode.tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class sumRootToLeaf {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){}
        public TreeNode(int val){this.val = val;}
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        private int res;
        public int sumRootToLeaf (TreeNode root) {
            subBinary(root, 0);
            return res;
        }

        /**
         * use a temp variable record val for this node,
         * if node is leaf, compute sum
         * @param root
         * @param cur
         */
        public void subBinary(TreeNode root, int cur) {
            if (root == null) return ;
            int tmp = cur*2 + root.val;
            if (root.left == null && root.right == null) {
                res += tmp;
            }
            subBinary(root.left, tmp);
            subBinary(root.right, tmp);
        }
    }

    /**
     * use bfs
     */
    class Solution2 {
        public int sumRootToLeaf(TreeNode root){
            if (root == null) return 0;
            int res = 0;

            // define two queue, one for node, other for val
            Queue<TreeNode> queueNode = new LinkedList<>();
            Queue<Integer> queueVal = new LinkedList<>();
            queueNode.offer(root);
            queueVal.offer(root.val);
            while (!queueNode.isEmpty()) {
                TreeNode cur = queueNode.poll();
                int tmp = queueVal.poll();
                if (cur.left == null && cur.right == null) {
                    res += tmp;
                    continue;
                }
                if (cur.left != null) {
                    queueNode.offer(cur.left);
                    queueVal.offer(cur.left.val + (tmp<<1));
                }
                if (cur.right != null) {
                    queueNode.offer(cur.right);
                    queueVal.offer(cur.right.val + (tmp<<1));
                }
            }
            return res;
        }
    }
}
