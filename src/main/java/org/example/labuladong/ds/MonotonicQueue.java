package org.example.labuladong.ds;

import java.util.*;

public class MonotonicQueue {
    public static void main(String[] args) {
        MonotonicQueue queue = new MonotonicQueue();
        queue.push(1);
        queue.push(3);
        queue.push(2);
        queue.push(4);
        System.out.println(queue.max());
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(maxSlidingWindow(nums, 3));
        System.out.println(Arrays.asList(maxSlidingWindow(nums, 3)));
    }
    /**
     * 单调队列, 需要实现
     * 1. 在队尾添加元素n
     * 2. 返回队列最大值
     * 3. 若队首元素是n、删除该元素
     * 3个操作
     */
    private Deque<Integer> data = new ArrayDeque<>();

    public void push(int n) {
        while (!data.isEmpty() && data.peekLast() < n) {
            data.pollLast(); // 将小于n的元素全删掉
        }
        data.offerLast(n); // 将元素入队
    }

    public int max() {
        return data.peekFirst();
    }

    public void pop(int n) {
        if (!data.isEmpty() && data.peekFirst() == n) {
            data.pollFirst();
        }
    }


    /**
     * 返回窗口内最大值
     * @param nums 元素数据
     * @param k 滑动窗口大小
     * @return
     */
    static int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue win = new MonotonicQueue();
        List<Integer> res = new LinkedList<>();
        for (int i=0; i<nums.length; i++) {
            if (i<k-1) {
                win.push(nums[i]); // 先将win窗口填满
            } else {
                win.push(nums[i]); // 将第i-k+1个元素放入窗口
                res.add(win.max()); // 将第 i-k+1, i-1 这k个元素的最大值放入结果集
                win.pop(nums[i-k+1]); // 将最前边的元素出队, 即滑动窗口
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
