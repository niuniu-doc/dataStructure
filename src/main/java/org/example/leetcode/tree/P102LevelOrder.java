package org.example.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P102LevelOrder {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            /**
             * 使用bfs实现
             */
//            List<List<Integer>> res = new ArrayList<>();
//            Queue<TreeNode> queue = new LinkedList<>();
//            queue.offer(root);
//            while (!queue.isEmpty()) {
//                int size = queue.size();
//                List<Integer> level = new LinkedList<>();
//                for (int i=0; i<size; i++) {
//                    // 遍历当前层、将元素放入 level
//                    TreeNode cur = queue.peek();
//                    queue.poll();
//                    if (cur == null) continue;
//                    level.add(cur.val);
//                    queue.offer(cur.left); // 将cur.left, cur.right放入
//                    queue.offer(cur.right);
//                }
//                if (!level.isEmpty()) {
//                    res.add(level);
//                }
//            }
//            return res;

            /**
             * 使用dfs实现, 每次
             */
            List<List<Integer>> res = new ArrayList<>();
            if (root != null) {
                dfs(res, root, 0);
            }
            return res;
        }

        private void dfs(List<List<Integer>> res, TreeNode node, int level) {
            if(res.size() - 1 < level){
                // 新的一层
                res.add(new ArrayList<>());
            }
            res.get(level).add(node.val);
            if (node.left != null) dfs(res, node.left, level+1);
            if (node.right != null) dfs(res, node.right, level+1);
        }
    }
}
