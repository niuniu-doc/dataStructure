package org.example.linkedlist;

import java.util.*;

/**
 * 基于单链表LRU算法
 */
public class LRUBaseLinkedList<T> {
    private final static Integer DEFAULT_CAPACITY = 10;
    private SNode<T> headNode; // 头节点
    private Integer length; // 链表长度
    private Integer capacity; // 链表容量

    public LRUBaseLinkedList() {
        this.headNode = new SNode<>();
        this.length = 0;
        this.capacity = DEFAULT_CAPACITY;
    }

    public LRUBaseLinkedList(Integer capacity) {
        this.headNode = new SNode<>();
        this.length = 0;
        this.capacity = capacity;
    }

  public void add(T data) {
        SNode preNode = findPreNode(data);

        // 链表中存在、删除原数据、再插入到链表的头部
      if (preNode != null) {
          deleteElemOptim(preNode);
      } else {
          if (length >= this.capacity) {
              // 删除尾节点
              deleteElemAtEnd();
          }
      }
      insertElemAtBegin(data);
  }

    /**
     * 删除preNode的下一个节点
     */
    private void deleteElemOptim(SNode preNode) {
        SNode tmp = preNode.getNext();
        preNode.setNext(tmp.getNext());
        tmp = null;
        length--;
    }

    private void deleteElemAtEnd() {
        SNode ptr = headNode;
        if (ptr.getNext() == null) {
            return;
        }

        // 倒数第二个节点
        while (ptr.getNext().getNext() != null) {
            ptr = ptr.getNext();
        }

        SNode tmp = ptr.getNext();
        ptr.setNext(null);
        tmp = null;
        length--;
    }

    /**
     * 链表头部插入结点
     */
    private void insertElemAtBegin(T data) {
        SNode next = headNode.getNext();
        headNode.setNext(new SNode(data, next));
        length++;
    }

    /**
     * 查找元素的前一个节点
     * @return
     */
  private SNode findPreNode(T data) {
        SNode node = headNode;
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getElement())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
  }

  private void printAll() {
      SNode node = headNode.getNext();
      while (node != null) {
          System.out.println(node.getElement() + " ,");
          node = node.getNext();
      }
      System.out.println();
  }

    public class SNode<T> {
        private T element;
        private SNode next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public SNode() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.next());
            list.printAll();
        }
    }
}
