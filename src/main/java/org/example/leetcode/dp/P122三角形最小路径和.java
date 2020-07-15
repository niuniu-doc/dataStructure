package org.example.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定三角形，每次只能移动到下一行中的相邻结点，求从顶点到底边的最小路径和
 */
public class P122三角形最小路径和 {
    public static void main(String[] args) {
        /**
         * [
         * [2],
         * [3,4],
         * [6,5,7],
         * [4,1,8,3]
         * ]
         */
        Integer[] a = {2};
        Integer[] b = {3, 4};
        Integer[] c = {6, 5, 7};
        Integer[] d = {4,1,8,3};
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(a));
        list.add(Arrays.asList(b));
        list.add(Arrays.asList(c));
        list.add(Arrays.asList(d));
        System.out.println(new Solution().minimumTotal(list));
    }
    static class Solution {
//        public int minimumTotal(List<List<Integer>> triangle) {
//            /**
//             * 一、暴力求解
//             * 任意一点到三角形底边的最小路径 = min(f(i+1, j), f(i+1, j+1)) + 自身的值
//             * f(i, j) = min(f(i+1, j), f(i+1, j+1)) + (i, j)
//             */
//            return dfs(triangle, 0, 0);
//        }
//
//        private int dfs(List<List<Integer>> triangle, int i, int j) {
//            if (i == triangle.size()) return 0;
//            System.out.println("i="+i+", j="+j +", min=" + Math.min(dfs(triangle, i+1, j), dfs(triangle, i+1, j+1)) + triangle.get(i).get(j));
//            return Math.min(dfs(triangle, i+1, j), dfs(triangle, i+1, j+1)) + triangle.get(i).get(j);
//        }

//        /**
//         * 二、递归 + 记忆化搜索
//         */
//        Integer[][] memo;
//        public int minimumTotal(List<List<Integer>> triangle) {
//            memo = new Integer[triangle.size()][triangle.size()];
//            return dfs(triangle, 0, 0);
//        }
//
//        private int dfs(List<List<Integer>> triangle, int i, int j) {
//            if (i == triangle.size()) return 0;
//            if (memo[i][j] != null) return memo[i][j];
//            return memo[i][j] = Math.min(dfs(triangle, i+1, j), dfs(triangle, i+1, j+1)) + triangle.get(i).get(j);
//        }

        /**
         * 三、DP, 其实就是 自顶向下递归 改为-> 自底向上递推
         *    状态方程: dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle[i][j]
         * @return
         */
//        public int minimumTotal(List<List<Integer>> triangle) {
//            int[][] dp = new int[triangle.size()][triangle.size()];
//            for (int i=triangle.size()-1; i>=0; i--) {
//                for (int j=0; j<=i; j++) {
//                    /**
//                     * dp[3][0], dp[3][1], dp[3][2], dp[3][3]
//                     */
//                    if (i == triangle.size()-1) dp[i][j] = triangle.get(i).get(j);
//                    else dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
//                }
//            }
//            return dp[0][0];
//        }

        /**
         * 四、dp, 使用一个数字来记录min值即可
         * @return
         */
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[] dp = new int[n+1];
            for (int i=n-1; i>=0; i--) {
                for (int j=0; j<=i; j++) {
                    dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
                }
            }
            return dp[0];
        }

    }
}
