package org.example.leetcode.greedy;

public class P860柠檬水找零 {
    public class Solution {
        public boolean lemonadeChange(int[] bills) {
            /**
             * 解题思路:
             * 若用户给的是5元, 不处理找零, five累加
             * 若用户给的是10元, 需要找回5元, ten++(用于20找零), five--
             * 若用户给的是20元, 需要找回15(ten+five | five*3)
             * 其余case返回false
             */
            if (bills.length == 0) return false;
            int ten = 0; int five = 0;
            for (int bill : bills) {
                if (bill == 5) {
                    five++;
                } else if (bill == 10) {
                    if (five == 0) return false;
                    five--;
                    ten++;
                } else {
                    // ￥20
                    if (ten >  0 && five > 0) {
                        ten--;
                        five--;
                    } else if (five >= 3) {
                        five -= 3;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
