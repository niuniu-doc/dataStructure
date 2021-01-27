package org.example.leetcode.list;

import java.util.List;

public class kthToLast {
    public static void main(String[] args) {

    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }

    /**
     * 找出单向链表中倒数第 k 个节点, 返回该节点的值
     * @param head
     * @param k
     * @return
     */
    public static int kthToLast(ListNode head, int k) {
      ListNode p = head;
      for (int i=0; i<k; i++){
          p = p.next;
      }
      while (p != null) {
          p = p.next;
          head = head.next;
      }
      return head.val;
    }
}
