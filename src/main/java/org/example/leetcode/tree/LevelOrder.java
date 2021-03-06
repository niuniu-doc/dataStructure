package org.example.leetcode.tree;

import java.util.*;

public class LevelOrder {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode () {}
        public TreeNode (int val) {
            this.val = val;
        }
        public TreeNode (int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution{
        public List<List<Integer>> LevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            Deque<TreeNode> queue = new ArrayDeque<>();

            queue.push(root);
            while (!queue.isEmpty()) {
                int n = queue.size();
                List<Integer> level = new ArrayList<>();
                for (int i=0; i<n; i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left != null) queue.add(node.left); // 将其子节点放到队尾
                    if (node.right != null) queue.add(node.right);
                }
            }
            return ans;
        }
    }
}
