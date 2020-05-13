package org.example.leetcode;

import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 */
public class P88合并有序数组 {
    public class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            /**
             * 解法一: 使用数组copy, 然后排序数组,
             *        时间复杂度 O((m+n)log(m+n)), 空间复杂度 O(1)
             */
//            System.arraycopy(nums2, 0, nums1, m, n);
//            Arrays.sort(nums1);

            /**
             * 方法二: 使用双指针, 从开头开始, 需要利用一个 m+n 大小的空间
             *        时间复杂度: O(m+n), 空间复杂度 O(m)
             */
            // 先copy数组1, 用指针存储 nums_copy 和  nums2 两个数组的元素, 对比、将较小的写入 nums1数组
//            int[] nums1_copy = new int[m];
//            System.arraycopy(nums1, 0, nums1_copy, 0, m);
//            int p = 0;
//            int q = 0;
//            while (p < m && q < n) {
//                nums1[p+q] = nums1_copy[p] < nums2[q] ? nums1_copy[p++] : nums2[q++];
////                if (nums1_copy[p] <= nums2[q]) {
////                    nums1[p+q] = nums1_copy[p];
////                    p++;
////                } else {
////                    nums1[p+q] = nums2[q];
////                    q++;
////                }
//            }
//            if (p<m) {
//                // 说明 nums2 数组数据已处理完成, 处理剩下的 nums1数组元素即可
//                System.arraycopy(nums1_copy, p, nums1, p+q, m-p);
//            }
//
//            if (q<n) {
//                System.arraycopy(nums2, q, nums1, p+q, n-q);
//            }

            /**
             * 方法三: 从后往前向nums1数组中填充元素, 无需申请额外的空间
             *        时间复杂度 O(m+n), 空间复杂度 O(1)
             */
            int p = m-1; // 指向nums1中数组元素
            int q = n-1; // 指向nums2中数组元素
            int cur = m+n-1;
            while (p>=0 && q>=0) {
                if (nums1[p] < nums2[q]) {
                    nums1[cur--] = nums2[q]; q--;
                } else {
                    nums1[cur--] = nums1[p]; p--;
                }
            }

            System.arraycopy(nums2, 0, nums1, 0, n-q);
        }
    }
}



