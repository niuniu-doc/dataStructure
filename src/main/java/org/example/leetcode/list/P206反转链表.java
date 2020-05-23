package org.example.leetcode.list;

public class P206反转链表 {
    public class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    class Solution {
        public ListNode reverseList(ListNode head) {
           ListNode pre = null;
           ListNode cur = head;
           while (cur != null) {
               ListNode tmp = cur.next; // 先临时保存节点
               cur.next = pre; // 将节点反转
               pre = cur;
               cur = tmp;
           }
           return pre;
        }
    }
}
