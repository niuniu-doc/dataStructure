package org.example.leetcode.everyDay;

import java.util.LinkedList;
import java.util.List;

public class P1431KidsWithCandies {
    public static void main(String[] args) {
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;
        System.out.println(new Solution().kidsWithCandies(candies, extraCandies));
    }
    static class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            /**
             * 拥有糖果最多的孩子
             * 孩子在原有糖果的基础上、若给予额外的糖果、能否成为拥有糖果最多的孩子
             * 1. 孩子本身拥有最多的糖果
             * 2. 孩子拥有的糖果+extra >= max
             */
            if (candies == null) return null;
            List<Boolean> res = new LinkedList<>();
            if (candies.length == 1) {
                // 只有一个元素, 本身就是糖果最多的孩子
                res.add(true);
                return res;
            }

            int max = 0;
            for (int candy : candies) {
                if (candy > max) max = candy;
            }

            for (int candy : candies) {
                res.add(candy + extraCandies >= max);
            }
            return res;
        }
    }
}
