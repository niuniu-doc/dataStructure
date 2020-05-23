package org.example.leetcode.list;

import java.util.List;

public class P24交换链表节点 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(new ListNode(arr));
        System.out.println(new Solution().swapPairs(new ListNode(arr)));
    }
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode(int[] arr) {
            this.val = arr[0];
            ListNode cur = this;
            for (int i = 1; i < arr.length; i++) {
                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ListNode [");
            ListNode cur = this;
            while (cur != null) {
                sb.append(cur.val).append("->");
                cur = cur.next;
            }
            sb.append("null]");
            return sb.toString();
        }
    }
    static class Solution {
        public ListNode swapPairs(ListNode head) {
            /**
             * 递归解法:
             * 1. 终止条件 head.next = null || head.next.next = null
             *    无节点(偶数个节点, 正好交换完成) or 只有一个节点(无需再交换)
             * 2. 交换: head.next = swap的节点, next.next = head
             * 3. 处理当前信息: return head;
             */
            if (head == null || head.next == null) {
                return head;
            }
            ListNode next = head.next;
            head.next = swapPairs(next.next);
            next.next = head;
            return next;

//            ListNode dummy = new ListNode(0);
//            dummy.next = head;
//            ListNode d = dummy;
//            ListNode fast, slow;
//            while (d.next != null && d.next.next!=null) {
//                fast = d.next.next;
//                slow = d.next;
//
//                // swap
//                slow.next = fast.next;
//                fast.next = slow;
//                d.next = fast;
//
//                // remove cur pointer
//                d = d.next.next;
//            }
//
//            return dummy.next;
        }
    }
}
