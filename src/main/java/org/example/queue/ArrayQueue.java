package org.example.queue;

import org.example.array.DynamicArray;

public class ArrayQueue<E> implements Queue<E> {
    private DynamicArray<E> array;

    public ArrayQueue(int capacity) {
        array = new DynamicArray<>(capacity);
    }

    public ArrayQueue() {
        array = new DynamicArray<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast((E) e);
    }

    @Override
    public E dequeue() throws Exception{
        return array.removeFirst();
    }

    @Override
    public E getFront() throws Exception{
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            try {
                res.append(array.get(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("]");

        return String.valueOf(res);
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue.toString());
    }
}
