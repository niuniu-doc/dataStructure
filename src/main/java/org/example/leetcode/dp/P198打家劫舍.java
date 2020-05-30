package org.example.leetcode.dp;

public class P198打家劫舍 {
    class Solution {
        public int rob(int[] nums) {
            /**
             * dp:
             * 1. 找重复子问题
             * 2. 定义状态数组
             * 3. 递推方程(dp方程)
             * 使用第二维代表前一家的偷盗状态
             */
//            if (nums == null || nums.length == 0) return 0; // 没有可偷盗的
//            int n = nums.length; // 总共有多少家
//            int[][] a = new int[n][2]; // 每家有偷或者不偷两种状态, 0不偷, 1偷
//
//            a[0][0] = 0; // 初始状态, 不偷则为0, 偷则为 第一家能偷的值
//            a[0][1] = nums[0];
//
//            for (int i=1; i<n; i++) {
//                // 若第i家不偷、前一家可能是偷或者不偷, 取max值即可;
//                // 若第i家偷、则前一家一定不能偷, 加上i这家能偷盗的值
//                a[i][0] = Math.max(a[i-1][0], a[i-1][1]);
//                a[i][1] = a[i-1][0] + nums[i];
//            }
//
//            return Math.max(a[n-1][0], a[n-1][1]);

            /**
             * 方法二
             * 因为不能偷连着的两家, 第i家偷盗总值 a[i] = max(a[i-1], a[i-2]+nums[i])
             */
            if (nums == null || nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
            int n = nums.length;
            int[] a = new int[n]; // 第i家可偷盗的最大值

            a[0] = nums[0];
            a[1] = Math.max(a[0], nums[1]);

            int res = Math.max(a[0], a[1]);
            for (int i = 2; i < n; i++) {
                a[i] = Math.max(a[i-1], a[i-2] + nums[i]);
                res = Math.max(res, a[i]);
            }

            return res;
        }
    }
}
