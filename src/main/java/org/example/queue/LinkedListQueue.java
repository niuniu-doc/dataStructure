package org.example.queue;

import org.example.Stack.LinkedListStack;
import org.example.linkedlist.DummyHeadLinekdList;
import org.example.linkedlist.LinkedList;

public class LinkedListQueue<E> implements Queue<E> {
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

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() throws Exception {
        if (isEmpty()) {
            try {
                throw  new Exception("e");
            } catch (Exception exception) {}
        }

        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null) tail = null;
        size--;

        return retNode.e;
    }

    public E getFront() {
        if (isEmpty()) {
            try {
                throw  new Exception("e");
            } catch (Exception exception) {}
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("null");
        return res.toString();
    }
}
