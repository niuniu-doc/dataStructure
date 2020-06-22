package org.example.labuladong.ds;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Stack {
    public static void main(String[] args) {
        int[] n = {2, 1, 2, 4, 3};
        System.out.println(nextElementGenerator(n));
    }

    // 单调栈
    static List<Integer> nextElementGenerator(int[] nums) {
        Integer[] res = new Integer[nums.length];
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (int i=nums.length-1; i>=0; i--) {
            while (!stack.empty() && stack.peek() <= nums[i]) {
                stack.pop(); // 小的值挪开、找到大于该元素的最后一个值
            }
            res[i] = stack.empty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return Arrays.asList(res);
    }
}
