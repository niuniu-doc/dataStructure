package org.example.leetcode.array;

public class P33搜索旋转排序数组 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target1 = 5;
        int target2 = 7;
        int target3 = 3;
        int target4 = 0;
        System.out.println(new Solution().search(nums, target1));
        System.out.println(new Solution().search(nums, target2));
        System.out.println(new Solution().search(nums, target3));
        System.out.println(new Solution().search(nums, target4));
    }
    static class Solution {
        public int search(int[] nums, int target) {
            /**
             * 解题思路:
             * 使用二分查找, 先判断旋转点,
             * 若 nums[low]<nums[mid], 属于不包含旋转点的半部分
             *    进行正常二分查找
             * 否则, 属于包含旋转点的半部分
             *    有旋转点,
             */
            int low = 0, high = nums.length-1, mid;
            while (low<=high) {
                if (low == high) return nums[low] == target ? low : -1;

                mid = low + ((high-low)>>1); // 计算中间元素的值
                if (target == nums[mid]) return mid;

                if (nums[low] <= nums[mid]) {
                    // 说明这半段无旋转发生
                    if ((nums[low] <= target) && (target <= nums[mid])) {
                        high = mid-1;
                    } else {
                        low = mid+1;
                    }
                } else {
                    if ((target >= nums[mid]) && (target <= nums[high])) {
                        low = mid+1;
                    }else {
                        high = mid-1;
                    }
                }
            }
            return -1;
        }
    }
}
