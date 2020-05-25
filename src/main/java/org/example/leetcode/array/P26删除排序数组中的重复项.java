package org.example.leetcode.array;

import java.util.HashSet;

public class P26删除排序数组中的重复项 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new Solution().removeDuplicates(nums));
        System.out.println(new Solution().removeDuplicates(nums2));
    }
    static class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums==null || nums.length == 0) return 0;
            /**
             * 重点: 有序数组
             */
            int p = 0, q = 1, j=0;
            while (q < nums.length) {
                if (nums[q] != nums[p]) {
                    if (q - p > 1) {
                        j++;
                        nums[p+1] = nums[q];
                    }
                    p++;
                }
                q++;
            }
            System.out.println("j=" + j);
            return p+1;
//            int j = 1;
//            HashSet<Integer> set = new HashSet<>(nums.length);
//            set.add(nums[0]);
//            for (int i = 1; i < nums.length; i++) {
//                if (nums[i] == nums[i-1]) continue;
//                if (!set.contains(nums[i])) {
//                    nums[j++] = nums[i];
//                    set.add(nums[i]);
//                }
//            }
//            return j;
        }
    }
}
