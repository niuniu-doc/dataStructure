package org.example.leetcode.dp;

public class P64最小路径和 {
    class Solution {
        public int minPathSum(int[][] grid) {
            /**
             * dp. 直接遍历, 计算每一步的最小路径和, 不需要额外空间,
             * 时间复杂度 O(mn), 空间复杂度 O(mn)
             * 左边界: dp[i][j] = dp[i-1][j] + grid[i][j]
             * 左边界: dp[i][j] = dp[i][j-1] + grid[i][j]
             * 左上角: dp[i][j] = grid[i][j]
             * 非边界: dp[i][j] = min(grid[i-1][j], grid[i][j-1]) + grid[i][j]
             */
            int m = grid.length; // 行数
            int n = grid[0].length; // 列数
            for (int i = 0; i < m; i++ ) {
                for (int j=0; j < n; j++) {
                    if (i == 0 && j==0) continue; // 初始化
                    else if (i == 0) grid[i][j] = grid[i][j-1] + grid[i][j];
                    else if (j == 0) grid[i][j] = grid[i-1][j] + grid[i][j];
                    else grid[i][j] = Math.min(grid[i][j-1], grid[i-1][j]) + grid[i][j];
                }
            }

            return grid[m-1][n-1];
        }
    }
}
