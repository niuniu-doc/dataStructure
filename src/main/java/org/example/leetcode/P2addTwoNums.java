package org.example.leetcode;


public class P2addTwoNums {
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode c1 = l1;
            ListNode c2 = l2;
            ListNode sentinel = new ListNode(0); // 设置虚拟头结点
            ListNode d = sentinel;

            int sum = 0;
            while ((c1 != null || c2 != null)) {
                // 处理结点数据
                sum /= 10;
                if (c1 != null) {
                    sum += c1.val;
                    c1 = c1.next;
                }
                if (c2 != null) {
                    sum += c2.val;
                    c2 = c2.next;
                }
                // 将监控结点后移
                d.next = new ListNode(sum % 10);
                d = d.next;
            }

            if (sum /10 == 1) d.next = new ListNode(1); // 处理最后的进位
            return sentinel.next;
        }
    }
}
