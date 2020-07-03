package org.example.myTest.array;

public class MyCircularQueue2 {
    private int[] data;
    private int size;
    private int front;
    private int rear;

    public MyCircularQueue2(int k) {
        data = new int[k];
        size = k;
        front = -1;
        rear = -1;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear+1)%size;
        data[rear] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        if (front == rear) {
            front = -1;
            rear = -1;
            return true;
        }
        front = (front+1)%size;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return data[front];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return data[rear];
    }

    public boolean isFull() {
        return ((rear+1)%size) == front;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public int getSize() {
        return size;
    }
}
