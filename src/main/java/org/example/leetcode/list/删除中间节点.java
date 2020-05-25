package org.example.leetcode.list;

public class 删除中间节点 {
    public static void main(String[] args) {
        String[] a = {"a", "b", "c", "d", "e", "f"};
        System.out.println(new 删除中间节点.ListNode(a));
        new Solution().deleteNode(new 删除中间节点.ListNode(a));
        System.out.println(new 删除中间节点.ListNode(a));
    }
    private static class ListNode {
        String val;
        ListNode next;
        public ListNode(String val) {
            this.val = val;
        }
        public ListNode(String[] arr) {
            this.val = arr[0]; // 处理第一个节点
            ListNode cur = this;
            for (int i = 1; i < arr.length; i++) {
                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            ListNode cur = this;
            while (cur != null) {
                sb.append(cur.val + " -> ");
                cur = cur.next;
            }
            sb.append("null ]");
            return sb.toString();
        }
    }
    static class Solution {
        public void deleteNode(ListNode node) {
            // 直接在原链表删除中间节点
            ListNode prev = new ListNode("0");
            prev.next = node;
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
