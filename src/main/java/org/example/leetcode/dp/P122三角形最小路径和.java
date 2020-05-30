package org.example.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P122三角形最小路径和 {
    class Solution {
//        int row;
//
//        public int minimumTotal(List<List<Integer>> triangle) {
//            /**
//             * 递归: 自顶向下
//             * row: 定义总行数, level: 定义当前层, c: 定义数据所在列
//             * 这种算法会超时
//             */
//            row = triangle.size();
//            return helper(0, 0, triangle);
//        }
//
//        private int helper(int level, int c, List<List<Integer>> triangle) {
//           if (level == row-1) return triangle.get(level).get(c);
//           int left = helper(level+1, c, triangle);
//           int right = helper(level+1, c+1, triangle);
//           return Math.min(left, right) + triangle.get(level).get(c);
//        }

//        int row;
//        Integer[][] memo;
//        public int minimumTotal(List<List<Integer>> triangle) {
//            /**
//             * 自顶向下, 记忆化搜索
//             * row: 定义总行数, c: 定义当前列, level: 定义当前行,
//             * memo: 存储第level行, c列的最短路径值, 避免重复计算
//             */
//            row = triangle.size();
//            memo = new Integer[row][row];
//            return helper(0, 0, triangle);
//        }
//
//        private int helper(int level, int c, List<List<Integer>> triangle) {
//           if (memo[level][c] != null) return memo[level][c]; // 若基于该点的最短路径已经被计算过, 直接使用
//           if (level == row-1) return memo[level][c] = triangle.get(level).get(c); // 最后一层, 将最短路径保存
//           // 否则进行递归计算
//           int left =  helper(level+1, c, triangle);
//           int right = helper(level+1, c+1, triangle);
//           return memo[level][c] = Math.min(left, right) + triangle.get(level).get(c); // 计算当前点的最短路径并保存结果
//        }

        public int minimumTotal(List<List<Integer>> triangle) {
            /**
             * dp, dp[level][c] = min(dp[level+1][c], dp[level+1][c+1]) + list.get(level).get(c)
             */
            int row = triangle.size();
            int[] minlen = new int[row+1]; // 定义状态数组、用来保存当前行的最小值
            for (int level = row-1; level >= 0; level--) {
                // 处理每一行的数据
                for (int c = 0; c <= level; c++) {
                    minlen[c] = Math.min(minlen[c], minlen[c+1]) + triangle.get(level).get(c);
                }
            }
            return minlen[0];
        }

    }
}
