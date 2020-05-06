package org.example.linkedlist;

public class DummyHeadLinekdList<E> {
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

    private Node dummyHead;
    int size;

    public DummyHeadLinekdList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    // 获取链表中元素个数

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
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

        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next; // 找到index的前一个节点

        // prev.next = new Node(e, prev.next)
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
        size++;

    }

    // 添加元素
    public void addFirst(E e) {
        // head = new Node(e, next)
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            try {
                throw new Exception("illegal index.");
            } catch (Exception e) { }
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.e;
    }

    public E getIndex(int index) {
        if (index < 0 || index >= size) {
            try {
                throw new Exception("illegal index.");
            } catch (Exception e) {

            }
        }

        Node cur = dummyHead.next;
        for (int  i = 0 ; i < index; i++) {
            cur = cur.next;
        }

        return cur.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size-1);
    }

    // 获取链表第一个元素
    public E getFirst() {
        return getIndex(0);
    }

    public E getLast() {
        return getIndex(size-1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            try {
                throw new Exception("illegal index.");
            } catch (Exception exception) {

            }
        }

        Node cur = dummyHead.next;
        for (int i = 0;  i < index; i++) {
            cur = cur.next;
        }

        cur.e = e;
    }

    public void removeElement(E e) {

    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
//        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
//            res.append(cur + "->");
//        }
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("null");
        return res.toString();
    }

    public static void main(String[] args) {
        DummyHeadLinekdList<Integer> list = new DummyHeadLinekdList<>();
        for (int i = 0; i<5; i++) {
            list.addFirst(i);
            System.out.println(list);
        }
        list.add(2, 666);
        System.out.println(list);

        list.remove(2);
        System.out.println(list);
    }
}
