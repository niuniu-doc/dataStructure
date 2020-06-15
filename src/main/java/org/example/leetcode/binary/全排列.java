package org.example.leetcode.binary;

import java.util.LinkedList;
import java.util.List;

public class 全排列 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution().permute(nums));
    }

    static class Solution {
        List<List<Integer>> res = new LinkedList<>();

        List<List<Integer>> permute(int[] nums) {
            LinkedList<Integer> track = new LinkedList<>(); // 记录路径
            backtrack(nums, track);
            return res;
        }

        /**
         * 路径: 记录在track中
         * 选择条件: nums中不存在于track中的那些元素
         * 结束条件: nums中的元素全都在track中出现
         * @param nums
         * @param track
         */
        private void backtrack(int[] nums, LinkedList<Integer> track) {
            if (track.size() == nums.length) {
                res.add(new LinkedList<>(track)); // 结束条件
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                // 排除不合法选择
                if (track.contains(nums[i])) continue;
                track.add(nums[i]); // 选择
                backtrack(nums, track); // 进入下一次选择
                track.removeLast(); // 撤销选择
            }
        }
    }
}
