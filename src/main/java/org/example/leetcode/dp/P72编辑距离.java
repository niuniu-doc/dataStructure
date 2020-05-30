package org.example.leetcode.dp;

public class P72编辑距离 {
    class Solution {
        public int minDistance(String word1, String word2) {
            /**
             * dp[i][j]表示 word1 到 i 位置, 转换为 word2 到 j 位置的最小路径
             * word1[i] == word2[j] 时, 代表: dp[i][j] == dp[i-1][j-1]
             * word1[i] != word2[j] 时,
             * dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
             * 其中: dp[i-1][j-1] 代表替换, dp[i-1][j] 代表删除, dp[i][j-1]代表插入
             * 首行首列用空格代替
             */
            int n1 = word1.length();
            int n2 = word2.length();
            int[][] dp = new int[n1 + 1][n2 + 1];
            // 初始化状态数组
            for (int i = 1; i <= n2; i++) dp[0][i] = dp[0][i - 1] + 1; // 第一行
            for (int j = 1; j <= n1; j++) dp[j][0] = dp[j - 1][0] + 1; // 第一列

            for (int i = 1; i <= n1; i++) {
                for (int j = 1; j <= n2; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                    else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
            return dp[n1][n2];
        }
    }
}
