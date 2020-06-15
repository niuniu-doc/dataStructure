package org.example.leetcode.binary;

import java.util.Arrays;

public class P338比特位计数 {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(Arrays.toString(new Solution().countBits(n)));
    }
    static class Solution {
        public int[] countBits(int num) {
            /**
             * 方法一: 在第一个数字包含1的个数上累加
             * 奇数, 一定比前边那个偶数多一个1; 偶数, 一定与除以2之后的那个数一样多
             * 1 -> 01 -> 1
             * 2 -> 10 -> 1
             * 3 -> 11 -> 2
             * 4 -> 100 -> 1
             * 5 -> 101 -> 2
             * 6 -> 110 -> 2
             * 7 -> 111 -> 3
             */
//            int[] res = new int[num+1];
//            res[0] = 0; // 0不包含1
//            for (int i=1; i<=num; i++) {
//                if (i % 2 == 1) { // 奇数
//                    res[i] = res[i-1] + 1;
//                } else {
//                    res[i] = res[i/2];
//                }
//            }
//            return res;

            /**
             * 方法二: 思路同上、换成位移操作
             * (num & 1) == 1, 奇数, 1的个数=前一个偶数+1
             * 否则, 偶数, 等于 i/2 中1的个数
             */
//            int[] res = new int[num+1];
//            res[0] = 0;
//            for (int i=1; i<=num; i++) {
//                res[i] = 1 == (i & 1) ? res[i-1]+1 : res[i>>1];
//            }
//            return res;
            /**
             * dp
             * x 与 x/2 的1的个数差别为 i&1,
             */
            int[] res = new int[num+1];
            res[0] = 0;
            for (int i=1; i<=num; i++) {
                res[i] = res[i>>1] + (i&1);
            }
            return res;
        }
    }
}














