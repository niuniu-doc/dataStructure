package org.example.leetcode.array;

public class P11MostWaters {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height2 = {2,3,4,5,18,17,6};
        System.out.println(new Solution().maxArea(height));
        System.out.println(new Solution().maxArea(height2));
    }
    static class Solution {
        public int maxArea(int[] height) {
            int max = 0, j = height.length-1, i=0;
            while (i<j) {
                max = Math.max(max, (j-i)*Math.min(height[i], height[j]));
                if (height[i]>height[j]) {
                    j--;
                } else {
                    i++;
                }
            }
            return max;
        }
    }
}
