package org.example.leetcode.binary;

public class P190颠倒二进制位 {
    public static void main(String[] args) {
        int n = 22;
        System.out.println(new Solution().reverseBits(n));
    }
    static class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            /**
             * 方法一: 循环颠倒每一位
             * n&1 得到最后一位, n>>>1 逻辑右移,
             * 相当于、每次逻辑右移, 取出最后一位, 设置到相应位上
             */
//            int ans = 0;
//            for (int bitSize=31; n!=0; n=n>>>1, bitSize--) {
//                ans += (n&1) << bitSize;
//            }
//
//            return ans;
            /**
             * 方法二: 原地交换, 空间复杂度 O(1)
             * (n>>(31-i))&1, 得到第31-i位, 即从左边数第i位
             * (n>>(31-i))&1 << i, 将左边第i位挪到右边第i位,
             * 即: 交换 第i位 和 第 31-i 位
             *
             * ret | (n>>(31-i))&1 << i, 即 设置该位的值
             */
            int ret = 0;
            for (int i=31; i>=0; i--) {
                ret = ret | ((n>>(31-i))&1) << i;
                System.out.println("i= " + Integer.toBinaryString(i));
                System.out.println("n>>(31-i)= " + Integer.toBinaryString((n>>(31-i))));
                System.out.println("n>>(31-i)&1= " + Integer.toBinaryString(((n>>(31-i))&1)));
                System.out.println("(n>>(31-i)&1)<<i= " + Integer.toBinaryString((((n>>(31-i))&1)<<i)));
                System.out.println("ret " + Integer.toBinaryString(ret));
            }
            return ret;
        }
    }
}
