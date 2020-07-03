package org.example.myTest.array;

import java.util.Arrays;

public class MyCircularQueue {
    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(4);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        int a = queue.front;
        int b = queue.rear;
        System.out.println(a);
        System.out.println(queue);
        System.out.println(b);
        queue.deQueue();
        queue.enQueue(4);
        System.out.println(queue);
        queue.deQueue();
        queue.enQueue(5);
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());
        System.out.println(queue);
    }

    int[] items;
    private final int capacity;
    private int front; // head
    private int rear; // tail

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        items = new int[k];
        this.capacity = k;
        front = 0;
        rear = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        items[rear%capacity] = value;
        rear = (rear+1)%capacity;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) return false;
        items[front%capacity] = 0;
        front = (front+1)%capacity;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return items[front%capacity];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return items[(rear-1)%capacity];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return front == rear;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return Math.abs(front-rear)+1 == capacity;
    }

    @Override
    public String toString() {
        return "MyCircularQueue{" +
                "items=" + Arrays.toString(items) +
                ", capacity=" + capacity +
                ", front=" + front +
                ", rear=" + rear +
                '}';
    }
}
