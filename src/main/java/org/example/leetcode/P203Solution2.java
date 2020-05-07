package org.example.leetcode;

public class P203Solution2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head.toString());

        ListNode res = (new Solution()).removeElements(head, 6);
        System.out.println(res);
    }

    public static class ListNode {
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
            StringBuilder res = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                res.append(cur.val + "->");
                cur = cur.next;
            }
            res.append("null");
            return res.toString();
        }
    }

    public static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) return null;

            ListNode res = removeElements(head.next, val);
            if (head.val == val) {
                return res;
            } else {
                head.next = res;
                return head;
            }
        }
    }


}
