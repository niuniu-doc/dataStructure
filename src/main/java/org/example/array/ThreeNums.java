package org.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNums {
    /**
     * if nums==null || nums.length<3, return null
     * sort array
     * if nums[i]>0, sums>0, return
     * if nums[i]==nums[i++] continue ;// repeat
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;
        Arrays.sort(nums);

        int len = nums.length;
        for (int i=0; i<nums.length;i++) {
            if (nums[i]>0) return ans;
            if (i>0 && nums[i] == nums[i-1]) continue;
            int L = i + 1;
            int R = len - 1;
            while (L<R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (nums[L] == nums[L+1]) L++;
                    while (nums[R] == nums[R-1]) R--;
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }
}
