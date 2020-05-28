package org.example.leetcode.list;


public class P2addTwoNums {
    public static void main(String[] args) {
        int[] arr1 = {8, 6, 7};
        int[] arr2 = {3, 0, 2};
        System.out.println(new ListNode(arr1));
        System.out.println(new Solution().addTwoNumbers(new ListNode(arr1), new ListNode(arr2)));
    }

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
        // get list from array
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
           sb.append("ListNode : [ ");
           ListNode cur = this;
           while (cur != null) {
               sb.append(cur.val + " -> ");
               cur = cur.next;
           }
           sb.append("null]");
           return sb.toString();
        }
    }
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode c1 = l1;
            ListNode c2 = l2; // 复制新的链表出来, 不改变原链表
            ListNode sentinel = new ListNode(0); // 设置虚拟头结点, 监控节点
            ListNode d = sentinel; // 移动指针
            int sum = 0;

            while (c1 != null || c2 != null) {
                // deal carry
                sum /= 10;
                if (c1 != null) {
                    sum += c1.val;
                    c1 = c1.next;
                }

                if (c2 != null) {
                    sum += c2.val;
                    c2 = c2.next;
                }

                d.next = new ListNode(sum % 10);
                d = d.next; // move to next node
            }

            // deal last carry
            if (sum/10 == 1) d.next = new ListNode(1);

            return sentinel.next; // 返回监控节点的后续节点
        }
    }
}
