package org.example.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSums {
    public static void main(String[] args) throws Exception{
        Solution solution = new TwoSums().new Solution();
        int[] nums = new int[] {1,2,3,3,2,5,8};
        int target = 9;

        try {
            int[] res = solution.twoSum(nums, target);
            System.out.println(Arrays.toString(res));
        } catch (Exception e) {
            throw e;
        }
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) throws Exception{
            // 1. 暴力解法, 两遍遍历
//            for (int i = 0; i < nums.length; i++) {
//                for (int j = i+1; j < nums.length; j++) {
//                    // var define at first can be faster ?
//                    if (nums[j] == target - nums[i]) {
//                        // no repeat answer, return.
//                        return new int[] {i, j};
//                    }
//                }
//            }
//            return new int[0];

//            // 2. 两遍hash表法
//            Map<Integer, Integer> map = new HashMap<>();
//            for (int i = 0; i < nums.length; i++) {
//                map.put(nums[i], i);
//            }
//
//            /**
//             * 看到有讨论区说:
//             * hashMap 在遇到重复值时、会丢掉一个元素, 特地测试了下、确实是这样的
//             * 后添加的会把先添加的值覆盖掉.
//             * eg. nums = new int[] {1,4,3,3,2,5,8}
//             *     target = 7, 这组测试数据, 就会得到 [0,3], 实际得到的应该是 [0,2]
//             * 但是我特地在 leetcode 上测了下、这个用例、结果标记为通过, 测试结果那里显示的
//             * 预期 [0,2], 结果 [0,3] 说明 [0,3]这组结果也可以认为是对的.
//             */
//            for (int i = 0; i < map.size(); i++) {
//                int complement = target - nums[i];
//                if (map.containsKey(complement) && map.get(complement) != i) {
//                    return new int[]{i, map.get(complement)};
//                }
//            }
//
//            return new int[0];


            /**
             * 一遍hash法, 边放入map, 边回视
             * 时间复杂度和空间复杂度都是 O(n)
             * 比两次遍历好处在于: 找到满足条件的数据即终止, 可能会降低空间复杂度
             * 最好情况下: i=0, j=1 即满足条件, 空间复杂度为 O(1), 时间复杂度为O(1)
             * 最坏情况下: i=num.length-1, j=num.length-2, 时间、空间复杂度都是 O(n)
             * 平均情况下: 时间、空间复杂度出现在 1...(num.length-1)的概率相等,
             * 假定 n = num.length-1
             * O((1/n)*1) + O((1/n)*2) +... + O((1/n)*n) = O((1+2+...+n)/n) = n(n+1)/2n = O(n)
             */
            HashMap<Integer, Integer> map = new HashMap<>(nums.length); // 避免动态扩容
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement) && map.get(complement) != i) {
                    // map中已包含符合条件的数据.
                    return new int[]{map.get(complement), i};
                }
                map.put(nums[i], i);
            }
            return new int[0];
        }
    }
}
