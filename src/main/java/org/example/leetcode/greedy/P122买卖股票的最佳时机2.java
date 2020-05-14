package org.example.leetcode.greedy;

public class P122买卖股票的最佳时机2 {
    class Solution {
        public int maxProfit(int[] prices) {
            /**
             * 题解思路:
             * 如果上涨就抛售、即: 若当天价格>前一天价格就抛出, 收益: 当天 - 前一天
             */
            int total = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i-1]) {
                    total += prices[i] - prices[i-1];
                }
            }
            return total;
        }
    }
}
