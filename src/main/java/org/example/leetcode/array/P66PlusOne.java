package org.example.leetcode.array;

import java.util.Arrays;

public class P66PlusOne {
    public static void main(String[] args) {
        int[] digits = {1, 2, 3};
        int[] digits2 = {1, 9, 9};
        int[] digits3 = {9, 9};
        System.out.println(Arrays.toString(new Solution().plusOne(digits)));
        System.out.println(Arrays.toString(new Solution().plusOne(digits2)));
        System.out.println(Arrays.toString(new Solution().plusOne(digits3)));
    }
    static class Solution {
        public int[] plusOne(int[] digits) {
            int len = digits.length;
            for (int i = len-1; i >= 0 ; i--) {
                digits[i]++;
                digits[i] %= 10; // 只保留余数就可以
                if (digits[i] != 0) {
                    return digits; // 若发生进位, 必定是9+1=10, 此位保留为0
                }
            }
            digits = new int[len+1];
            digits[0] = 1;
            return digits;
        }
    }
}
