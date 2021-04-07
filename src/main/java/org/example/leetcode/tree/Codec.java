package org.example.leetcode.tree;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * 序列化和反序列化二叉树
 * @link https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/solution/
 */
public class Codec {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){}
        public TreeNode(int val){this.val = val;}
        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> ans = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root == null) return "[]";
        deque.push(root);
        ans.add(root.val + "");
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            if (node == null) ans.add("null");
            ans.add(node.val + "");
            if (node.left != null) {
                deque.add(node.left);
            }
            if (node.right != null) deque.add(node.right);
        }
        return "[" + StringUtils.join(ans, "，") + "]";
    }

//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//
//    }
}
