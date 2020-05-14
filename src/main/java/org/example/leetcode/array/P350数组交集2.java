package org.example.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class P350数组交集2 {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5}; int[] nums2 = {9,4,9,8,4};
        int[] nums3 = {1, 2, 2, 1}; int[] nums4 = {2, 2, 1};
        System.out.println(Arrays.toString((new Solution()).intersect(nums1, nums2)));
        System.out.println(Arrays.toString((new Solution()).intersect(nums3, nums4)));
    }

    static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            /**
             * 遍历nums1数组、将数组1放入map中、
             * 再遍历nums2数组、
             *     若已存在于map、则放入结果集、同时将map中key出现的次数-1
             *     若map中key的val(出现次数为0)、则将key删除
             *
             */
            for (int num : nums1) {
                if (!map.containsKey(num)) {
                    map.put(num, 1);
                } else {
                    map.put(num, map.get(num) + 1);
                }
            }

            ArrayList<Integer> list = new ArrayList<>(map.size());
            for (int num : nums2) {
                if (map.containsKey(num)) {
                    list.add(num);
                    if (map.get(num) == 1) {
                        map.remove(num);
                    } else {
                        map.put(num, map.get(num)-1);
                    }
                }
            }

            // 将结果集转换为数组
            int[] res = new int[list.size()];
            for (int i = 0; i < list.size() ; i++) {
                res[i] = list.get(i);
            }

            return res;
        }
    }
}
