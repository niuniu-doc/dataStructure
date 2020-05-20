package org.example.leetcode.array;

import java.util.HashSet;
import java.util.Iterator;

public class P136只出现一次的数字 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,4};
        int[] nums2 = {2,2,1};
        System.out.println(new Solution().singleNumber(nums));
      //  System.out.println(new Solution().singleNumber(nums2));
    }
    static class Solution {
        public int singleNumber(int[] nums) {
            /**
             * 解题思路:
             * 一、暴力解法、直接两次遍历、时间复杂度 O(n²)
             * 二、排序、O(nlogn)
             * 三、扔进hashmap O(n)
             * 四、异或运算
             */
//            int cur, len = nums.length, j;
//            for (int i=0; i<len; i++) { // 遍历nums中的元素, 查找是否包含与当前元素等值的元素
//                cur = nums[i];
//                for (j = 0; j < len; j++) {
//                    if (j == i) continue;
//                    if (cur == nums[j]) break;
//                }
//                if (j == len) {
//                    return cur; // 查找完所有的元素都没找到等值元素
//                }
//            }
//            return -1;

            // 方法二
//           Arrays.sort(nums);
//           int len = nums.length, cur;
//           for (int i=0; i<len; i+=2) {
//               cur = nums[i];
//               if (i == len-1) return nums[i];
//               if (cur != nums[i+1]) return cur; // 若当前元素不等于下一个元素, 则当前元素为单个
//           }
//           return -1;

            // 方法三
//            int len = nums.length, cur;
//            HashSet<Integer> set = new HashSet<>(len);
//            for (int i = 0; i < len; i++) {
//                cur = nums[i];
//                if (!set.contains(cur)) {
//                    set.add(cur);
//                } else {
//                    set.remove(cur);
//                }
//            }
//            Iterator<Integer> iterator = set.iterator();
//            return set.size() == 1 ? iterator.next() : -1;

            // 方法四、异或运算
            int len = nums.length, ans = nums[0];
            for (int i = 0; i < len-1; i++) {
                ans = ans ^ nums[i+1];
            }
            return ans;
        }
    }
}
