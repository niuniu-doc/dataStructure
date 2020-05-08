package org.example.leetcode;

import org.example.segmenTree.SegmentTree;

public class P303NumArray {
    
    
    class NumArray {
        private SegmentTree<Integer> segmentTree;
        public NumArray(int[] nums) {
            if (nums.length > 0) {
                Integer[] data = new Integer[nums.length];
                for (int i = 0; i < nums.length; i++) {
                    data[i] = nums[i];
                }
                segmentTree = new SegmentTree<>(data, (a, b)->a+b);
            }
        }

        public void update(int index, int val) {
            segmentTree.set(index, val);
        }

        public int sumRange(int i, int j) {
            if (segmentTree == null) {
                System.out.println("error");
            }
            return segmentTree.query(i, j);
        }
    }
}
