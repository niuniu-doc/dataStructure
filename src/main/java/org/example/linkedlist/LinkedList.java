package org.example.linkedlist;

public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    // 获取链表中元素个数

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 添加元素
    public void addFirst(E e) {
        // head = new Node(e, next)
        Node node = new Node(e);
        node.next = head;
        head = node;
        size++;
    }

    // 在指定位置添加元素
    public void add(int index, E e) {
        if (index < 0 || index>size) {
            try {
                throw new Exception("error");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (index == 0) {
            addFirst(e);
        } else  {
            Node prev = head;
            for (int i = 0; i < index - 1; i++)
                prev = prev.next; // 找到index的前一个节点

            // prev.next = new Node(e, prev.next)
            Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;
            size++;
        }
    }

    public void addLast(E e) {
        add(size, e);
    }
}
