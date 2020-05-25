package org.example.leetcode.list;

public class P141hasCycle {

    public static void main(String[] args) {
        int[] arr1 = {3,2,0,-4};
        int[] arr2 = {1,2};
        int[] arr3 = {1};
        System.out.println(new ListNode(arr1));
        System.out.println(new ListNode(arr2));
        System.out.println(new ListNode(arr3));
        System.out.println(new Solution().hasCycle(new ListNode(arr1)));
        System.out.println(new Solution().hasCycle(new ListNode(arr2)));
        System.out.println(new Solution().hasCycle(new ListNode(arr3)));
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
            sb.append("ListNode: [");
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
        public boolean hasCycle(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast.next != null && fast.next.next != null && slow.next!= null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) return true;
            }
            return false;
        }
    }
}
