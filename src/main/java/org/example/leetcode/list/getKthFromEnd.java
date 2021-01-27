package org.example.leetcode.list;

public class getKthFromEnd {
    public static void main(String[] args) {

    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 返回倒数第k个节点
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = head;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }

        while (p.next != null) {
            p = p.next;
            head = head.next;
        }
        return head;
    }
}
