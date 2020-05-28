package org.example.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 四数之和 {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(new Solution().fourSum(nums, 0));
    }
    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            /**
             * 参考之前练习: 3数之和, 用指针移动法
             * 思路:
             * 1. 若数组为null 或者 数组长度<4, 不满足, 直接返回
             * 2. 排序数组
             * 3. 比3数之和, 多一层循环, 固定i, j 两个值, 另外加两个指针, 比较当前和与target
             *    特殊的点:
             *    1) 与前一个元素等值, 可直接进入下一轮循环
             *    2) 最小的4个值之和比target还大, 直接结束循环
             *    3) 当前值与最大的3个值之和比target小, 结束循环
             */
            if (nums == null || nums.length < 4) return new ArrayList<>(0);
            Arrays.sort(nums);

            List<List<Integer>> res = new ArrayList<>();
            int len = nums.length;
            for (int i=0; i<len-3; i++) {
                // 第一层循环, 固定一个值
                if (i>0 && nums[i] == nums[i-1]) continue; // 等值不重复判断
                // 排序后的数组, 最前边的四个元素(当前位置开始), 是最小的4个元素
                int min = nums[i] + nums[i+1] + nums[i+2] + nums[i+3];
                if (min > target) break; // 这组元素最小和都>target, 后边更大, 跳过

                // max是否比target小
                int max = nums[i] + nums[len-1] + nums[len-2] + nums[len-3];
                if (max < target) continue;

                // 第二层循环, 固定第二个值, 从i+1开始遍历即可
                for (int j = i+1; j < len-2; j++) {
                    if (j > i+1 && nums[j] == nums[j-1]) continue;
                    int L = j+1, R = len-1; // 活动指针, 指向下一个元素和末尾元素, 根据与target对比情况移动指针

                    int minSum = nums[i] + nums[j] + nums[L] + nums[L+1];
                    if (minSum > target) continue;

                    int maxSum = nums[i] + nums[j] + nums[R] + nums[R-1];
                    if (maxSum < target) continue;

                    while (L < R) {
                        // 移动指针, 查找sum = target的元素集合
                        int curSum = nums[i] + nums[j] + nums[L] + nums[R];
                        if (curSum == target) {
                            // 将元素放入结果数组
                            res.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                            while (L<R && nums[L+1] == nums[L]) L++;
                            while (L<R && nums[R-1] == nums[R]) R--;
                            L++;
                            R--;
                        } else if (curSum > target) {
                            // 右边值过大, 左移
                            R--;
                        } else {
                            L++;
                        }
                    }

                }
            }
            return res;
        }
    }
}









