package org.example.leetcode.binary;

public class P231IsPowerOfTwo {
    public static void main(String[] args) {
        int n = 32;
        int no = 22;
        System.out.println(new Solution().isPowerOfTwo(n));
        System.out.println(new Solution().isPowerOfTwo(no));
    }
    static class Solution {
        public boolean isPowerOfTwo(int n) {
            /**
             * 方法一: 判断1的个数, 2的n次方, 有且只有1个1
             */
//            int cnt = 0;
//            while (n>0) {
//                cnt++;
//                n &= n-1;
//            }
//            return cnt==1;

            /**
             * 方法二: n&(n-1)==0
             */
//            return n>0 && (n&(n-1))==0;
            /**
             * 方法三: 循环判断
             */
            if (n == 0) return false;
            while (n % 2 == 0) n /= 2;
            return n == 1;
        }
    }
}
