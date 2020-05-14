package org.example.leetcode.list;

public class P203删除链表节点 {

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
        ListNode(int x) {
            val = x;
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

    static class Solution {
        public ListNode removeElements(ListNode head, int val) {
//            // 处理链表开始部分
//            while (head != null && head.val == val) {
//                ListNode delNode = head;
//                head = head.next;
//                delNode.next = null;
//            }
//
//            // 若此时链表为空, 直接返回即可
//            if (head == null) return  null;
//
//            ListNode prev = head;
//            while (prev.next != null) {
//                // 下一个节点需要被删除
//                if (prev.next.val == val) {
//                    ListNode delNode = prev.next;
//                    prev.next = delNode.next;
//                    delNode.next = null;
//                } else {
//                    // 下一个节点不需要被删除、直接后移
//                    prev = prev.next;
//                }
//            }
//            return head;

            /*-------------------使用虚拟头结点----------*/
           ListNode dummyHead = new ListNode(-1);
           dummyHead.next = head;

           ListNode prev = dummyHead;
           while (prev.next != null) {
               if (prev.next.val == val) {
                   prev.next = prev.next.next;
               } else {
                   prev = prev.next;
               }
           }
           return dummyHead.next;
        }
    }
}
