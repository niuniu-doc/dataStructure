package org.example.leetcode.list;

public class P141hasCycle {
    public static void main(String[] args) {
        int[] arr = {3, 2, 0, -4};
       // System.out.println(new ListNode(arr));
        System.out.println(new Solution().hasCycle(new ListNode(arr)));
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
    static public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) return false;
            ListNode fast = head, slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (slow == fast) return true;
            }
            return false;
        }
    }
}
