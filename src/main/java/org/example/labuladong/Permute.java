package org.example.labuladong;

import java.util.LinkedList;
import java.util.List;

public class Permute {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution2().permute(nums));
    }

    static class Solution2 {
        List<List<Integer>> res = new LinkedList<>();
        public List<List<Integer>> permute(int[] nums) {
            // 特判
            if (nums.length == 0) return null;
            List<Integer> track = new LinkedList<>();
            backtrack(nums, track);
            return res;
        }
        private void backtrack(int[] nums, List<Integer> track) {
            // terminate
            if (track.size() == nums.length) {
                res.add(new LinkedList<>(track));
                return;
            }

            for (Integer e : nums) {
                if (track.contains(e)) continue; // 非法排除

                track.add(e); // 做选择
                backtrack(nums, track);
                track.remove(e); // 撤销选择
            }
        }
    }
}
