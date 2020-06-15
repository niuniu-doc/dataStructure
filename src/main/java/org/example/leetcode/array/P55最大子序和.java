package org.example.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class P55最大子序和 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Solution().maxSubArray(nums));
    }
    static class Solution {
        public int maxSubArray(int[] nums) {
            /**
             * 1. 暴力解法
             * 枚举右边界, 计算所有右边界到左边界的值的和, 计算max值
             * 其实是计算了每一个i,j的sum值, 看了好几遍才看懂~~~~
             */
//            if (nums == null) return 0;
//            if (nums.length < 2) return nums[0];
//
//            int n = nums.length, sum, max = 0;
//
//            List<Integer> tmp = new ArrayList<>(); // 存放最大子序和的起止索引
//            for (int i=0; i<n; i++) {
//                // 枚举右边界
//                sum = 0; // sum 存放从下标 i 开始, 到 最末尾的最大子序和, 若 sum>已有max, 则更新
//                for (int j=i; j<n; j++) {
//                    // 计算从右边界开始的每一个子序列的和
//                    sum += nums[j];
//                   // max = Math.max(sum, max);
//                    if (sum > max) {
//                        max = sum;
//                        tmp.clear();
//                        tmp.addAll(Arrays.asList(i, j));
//                    }
//                }
//            }
//            System.out.println(tmp);
//            return max;

            /**
             * dp
             * 1. 分解子问题
             *    1) 以第一个数字结尾的组合、只能是 (-2)
             *    2) 以第二个数字结尾的子组合、可能是 (-2, 1) (1), max = 1
             *    3) 以第三个数字结尾的子组合、可能是 (-3, 1, -2) (-3, 1) (-3), max = -2
             *    3) 以第四个数字结尾的子组合、可能是 (4, -3, 1, -2) (4, -3, 1) (4, -3) (4), max = 4
             * 2. 定义dp[i]为以i为结尾的子串的最大值
             * 3. dp方程: dp[i] = dp[i-1]+nums[i] : nums[i] (dp[i-1]<0, 则从头开始)
             * 4. 初始条件 dp[0]=nums[0]
             */
            int len = nums.length;
            if (len == 0) return 0;
            int[] dp = new int[len];
            dp[0] = nums[0];
            for (int i=1; i<len; i++) {
                dp[i] = dp[i-1] > 0 ? dp[i-1] + nums[i] : nums[i];
            }

            // 最后看一遍所有i结尾的最大值
            int res = dp[0];
            for (int i=0; i<len; i++) {
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
}
