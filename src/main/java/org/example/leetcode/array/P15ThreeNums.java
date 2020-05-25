package org.example.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15ThreeNums {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {-1, 0, -1, 1};
        System.out.println(new Solution().threeSum(nums));
        System.out.println(new Solution().threeSum(nums2));
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null || nums.length < 3) return new ArrayList<>(0);
            Arrays.sort(nums); // 将数组排序
            int L, R, sum, len = nums.length-1;
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                if (nums[i] > 0) return res;
                if (i>0 && nums[i] == nums[i-1]) continue;
                L = i+1; R=len;
                while (L<R) {
                    sum = nums[i] + nums[L] + nums[R];
                    if (sum > 0) {
                        R--; // 和>0, 说明右边界过大
                    } else if (sum < 0) {
                        L++; // 和<0, 左边界过小
                    } else {
                        // 将结果放入结果集
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.addAll(Arrays.asList(nums[i], nums[L], nums[R]));
                        res.add(tmp);
                        while (L<R && nums[L+1] == nums[L]) L++;
                        while (L<R && nums[R-1] == nums[R]) R--;
                        L++;
                        R--;
                    }
                }
            }
            return res;
        }
    }
}
