package org.example.leetcode.array;

import java.util.Arrays;

public class P283MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        new Solution().moveZeroes(nums);
    }
    static class Solution {
        public void moveZeroes(int[] nums) {
            if (nums.length <= 1) return;
            int j=0, len=nums.length;// 标记该填充的位置
            for (int i=0;i<len;i++) {
                if (nums[i]!=0){
                    if (i==j) {
                        j++;
                    } else {
                        nums[j++]=nums[i];
                    }
                }
            }
            while (j<nums.length) {
                nums[j++]=0;
            }
            System.out.println(Arrays.toString(nums));
        }
    }
}
