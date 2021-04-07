package org.example.leetcode.tree;

import org.example.je.A;

import java.util.*;
import java.util.concurrent.locks.Lock;

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
    enum Color{
        WRITE,
        GRAY;
    }
    class Solution3{

        public List<Integer> preOrder(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            Deque<TreeNode> deque = new ArrayDeque<>();
            TreeNode p = root;

            while (!deque.isEmpty() || p!= null) {
                if (p != null) {
                    deque.push(p);
                    ans.add(root.val);
                    p = p.left;
                } else {
                     TreeNode node = deque.pop();
                     p = node.right;
                }
            }
            return ans;
        }

        public List<Integer> inOrder(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            Deque<TreeNode> deque = new ArrayDeque<>();
            TreeNode p = root;

            while (!deque.isEmpty() || p!=null) {
                if (p!= null) {
                    deque.push(p);
                    p = p.left;
                } else {
                    TreeNode node = deque.pop();
                    ans.add(node.val);
                    p = node.right;
                }
            }
            return ans;
        }

        public List<Integer> postOrder(TreeNode root) {
            LinkedList<Integer> ans = new LinkedList<>();
            Deque<TreeNode> deque = new ArrayDeque<>();
            TreeNode p = root;

            while (!deque.isEmpty() || p!= null) {
                if (p != null) {
                    deque.push(p);
                    ans.addFirst(p.val);
                    p = p.right;
                } else {
                    TreeNode node = deque.pop();
                    p = node.left;
                }
            }
            return ans;
        }

    }


}
