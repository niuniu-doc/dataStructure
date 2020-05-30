package org.example.leetcode.array;

public class 跳跃II {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new Solution().jump(nums));
    }
    static class Solution {
        public int jump(int[] nums) {
            /**
             * 参考之前的跳跃游戏, 判断是否可跳到最后位置
             * 因为总是能跳到最后
             * 假设, 每次在当前位置可跳的最远位置
             */
            // end当前能跳的边界, masPos 能跳的最远位置, steps 用的步数
            int end = 0, maxPos = 0, steps = 0, len = nums.length-1;
            for (int i=0; i<len -1; i++) {
                maxPos = Math.max(maxPos, nums[i] + i);
                if (i==end) {
                    // 遇到边界, 更新边界, 步数+1
                    end = maxPos;
                    steps++;
                }
            }
            return steps;
        }
    }
}
