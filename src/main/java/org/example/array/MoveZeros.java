package org.example.array;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MoveZeros {
    public static void main(String[] args) {
        Solution solution = new MoveZeros().new Solution();
        int[] origin = new int[]{0,1,0,3,12};
        int[] res = solution.moveZeros(origin);
        System.out.println(Arrays.toString(res));
    }

    class Solution {
        public int[] moveZeros(int[] nums) {
            /**
             * 变量 curr 代表下一个非0元素存放的位置
             */
            int curr = 0, i ;
            for (i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    /**
                     * 这里若 i = curr, 说明之前的元素都是非0元素、无需交换, 可以是 稳定操作,
                     * 如果全部执行交换的话、就变成了 非稳定操作, 且时间复杂度会增加
                     */
                    if (i != curr) {
                        nums[curr] = nums[i]; // 是不是直接将 nums[i] 赋值给 nums[curr]即可 ?
                        nums[i] = 0;
                    }
                    curr ++;
                }
            }
            System.out.println(Arrays.toString(nums));
            return nums;
        }
    }
}
