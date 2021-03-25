package org.example.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class pathSum {
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
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            recur(root, sum);
            return ans;
        }
        public void recur(TreeNode cur, int target) {
           if (cur == null) return;
           path.add(cur.val);
           target -= cur.val;
           if (target == 0 && cur.left == null && cur.right == null) {
               ans.add(new LinkedList<>(path));
           }
           recur(cur.left, target);
           recur(cur.right, target);
           path.removeLast();
        }
    }
}
