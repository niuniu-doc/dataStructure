package org.example.leetcode.dp;

public class P70爬楼梯 {
    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(2));
        System.out.println(new Solution().climbStairs(3));
        System.out.println(new Solution().climbStairs(4));
    }
    static public class Solution {
        public int climbStairs(int n) {
            /**
             * 1. 暴力解法, 递归
             * 2. 记忆化递归
             * 3. dp
             * 4. 斐波那契数列
             */

            // 1: 暴力解法, 时间复杂度 O(2ⁿ)
          //  return climb_stairs(0, n);

            // 2: 记忆化递归, 时间复杂度 O(n), 空间复杂度 O(n)
//            int[] memo = new int[n+1];
//            return climb_stairs_memo(0, n, memo);

            /**
             * dp: 分解为子问题 sbProblem f(i) = f(i-1) + f(i-2)
             *     定义状态数组
             *     dp方程式 dp[n] = dp[n-1] + dp[n-2]
             */
//            if (n == 1) return 1;
//            int[] dp = new int[n+1];
//            dp[1] = 1; dp[2] = 2;
//            for (int i = 3; i <= n; i++) {
//                dp[n] = dp[n-1] + dp[n-2];
//            }
//
//            return dp[n];

            /**
             * 斐波那契数列 f(i) = f(i-1) + f(i-2)
             * 时间复杂度 O(n), 空间复杂度 O(1), 只需要一个变量临时存储计算结果就好
             */
            if (n==1) return 1;
            int first = 1, second = 2, third ;
            for (int i = 3; i <= n; i++) {
                third = first + second;
                first = second;
                second = third;
            }
            return second;
        }

        private int climb_stairs(int i, int n) {
            if (i > n) return 0;
            if (i == n) return 1;
            return climb_stairs(i+1, n) + climb_stairs(i+2, n);
        }

        private int climb_stairs_memo(int i, int n, int[] memo) {
            if (i > n) return 0;
            if (i == n) return 1;
            // 将 f(i) 的结果保存在 memo数组中、下次需要直接使用即可
            if (memo[i] > 0) return memo[i];
            return climb_stairs_memo(i+1, n, memo) + climb_stairs_memo(i+2, n, memo);
        }
    }
}
