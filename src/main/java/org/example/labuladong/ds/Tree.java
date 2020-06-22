package org.example.labuladong.ds;

public class Tree {
    class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * 将节点值+1
     */
    public void plusOne(TreeNode root) {
        if (root == null) return;
        root.val += 1;
        plusOne(root.left);
        plusOne(root.right);
    }

    /**
     * 判断两棵树是否相同
     */
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true; // 都是空树
        if (root1 == null || root2 == null) return false; // 有一颗非空
        if (root1.val != root2.val) return false; // 节点值不一致
        return isSameTree(root1.left, root2.left) && isSameTree(root2.left, root2.right);
    }

    boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public boolean isInBst(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target) return true;
        return isInBst(root.left, target) || isInBst(root.right, target);
    }

    /**
     * 优化, 若target比root.val小、则比较左子树, 否则比较右子树
     */
    public boolean isInBSTFast(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target) return true;
        if (root.val < target) return isInBSTFast(root.right, target);
        return isInBSTFast(root.left, target);
    }

    /**
     * 在bst中插入一个数
     */
    public TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        // 若待插入节点比root.val大、插入右子树, 否则、插入左子树
        if (root.val < val) root.right = insert(root.right, val);
        if (root.val > val) root.left = insert(root.left, val);
        return root;
    }

    /**
     * 删除一个节点
     */
    public TreeNode delNode(TreeNode root, int val) {
        if (root.val == val) {
            /**
             * 找到节点、删除
             * 1. 叶子节点、直接删除
             * 2. 只有一个非空子节点、接替自己的位置
             * 3. 两个子节点都存在, 用左子树最大的节点或者右子树最小的节点来替代
             */
            if (root.left == null && root.right == null) return null;

            if (root.left == null ) return root.right;
            if (root.right == null) return root.left;

            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = delNode(root.right, minNode.val);
        } else if (root.val < val) {
            root.right = delNode(root.right, val);
        } else {
            root.left = delNode(root.left, val);
        }
        return root;
    }

    /**
     * 完全二叉树、非叶子层节点都是满的、叶子层节点靠左排列
     * 满二叉树、所有层节点都是满的
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * 满二叉树, 2^h-1
     */
    public int countNodesFull(TreeNode root) {
        int h = 0;
        while (root != null) {
            root = root.left;
            h++;
        }
        return (int)Math.pow(2, h)-1;
    }

    /**
     * 完全二叉树, 判断是不是满二叉树, 若是、按照满二叉树计算, 否则、按照普通二叉树计算
     */
    public int countNodeComplete(TreeNode root) {
        TreeNode r = root, l = root;
        int hl=0, hr=0;
        while (r != null) {
            r = r.right;
            hr++;
        }

        while (l != null) {
            l = l.left;
            hl++;
        }

        if (hl == hr) return countNodesFull(root);
        return countNodes(root);
    }

    private TreeNode getMin(TreeNode root) {
        if (root.left == null) return root;
        return getMin(root.left);
    }

    private TreeNode getOlder(TreeNode root1, TreeNode root2) {
        return root1.val > root2.val ? root1 : root2;
    }

    private TreeNode getLesser(TreeNode root1, TreeNode root2) {
        return root1.val < root2.val ? root1 : root2;
    }
}
