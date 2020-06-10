package org.example.leetcode.binary;

public class P191位1的个数 {
    public static void main(String[] args) {
        int n = 22; // 10110
        System.out.println(new Solution().hammingWeight(n));
    }
    static class Solution {
        public int hammingWeight(int n) {
            /**
             * 方法一: 判断最低位是否为1
             * x&1 得到最低位的值
             */
//            int cnt = 0;
//            while (n!=0) {
//                cnt += n&1; // n&1 得到最低位的值
//                n >>>= 1; // 无符号移位操作
//            }
//            return cnt;

            /**
             * 方法二: 依次清0最低位的1、看操作多少次
             * x&(x-1) 清零最低位的1
             */
            int cnt = 0;
            while (n!=0) {
                n &= (n-1);
                cnt += 1;
            }
            return cnt;
        }
    }
}
