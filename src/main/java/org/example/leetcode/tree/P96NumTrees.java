package org.example.leetcode.tree;

public class P96NumTrees {
    public static void main(String[] args) {
        System.out.println(new Solution().numTrees(3));
    }
    static class Solution {
        public int numTrees(int n) {
            /**
             * 按照bst的定义、k个节点参与构建、1~k个节点参与构建左子树、则 k+1 ~ 1 个节点参与构建右子树
             * 以k为节点的bst种类数 = 左子树bst种类数 * 右子树bst种类数
             * 以k为节点数、固定左子树、可得到m种有右子树
             * 枚举n种左子树、可得到m*n种bst结构
             */
            int[] dp = new int[n+1];
            dp[0] = dp[1] = 1;
            for (int i=2; i<=n;i++) {
                for (int j=0; j<i; j++) {
                    dp[i] += dp[i]*dp[i-j-1];
                }
            }
            return dp[n];

        }
    }

}
