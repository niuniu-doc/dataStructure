package org.example.leetcode.list;

import java.util.List;

public class rotateRight {

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 将链表向右旋转k个元素
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
      if (head == null) return null; // 空链表直接返回
        ListNode fast = head, slow = head;
        int len=1;
        while (fast.next != null) {
            len++; // 计算链表长度
            fast = fast.next; // 移动指针
        }

        // 计算移动的步数
        int step = len - k%len;
        while (step-- > 1) { // 少走一步, 直接返回slow.next
            slow = slow.next; // 移动慢指针
        }

        // 将首尾相连, 并将慢指针断开, 返回slow.next
        fast.next = head;
        ListNode tmp = slow.next;
        slow.next = null;

        return tmp;
    }
}
