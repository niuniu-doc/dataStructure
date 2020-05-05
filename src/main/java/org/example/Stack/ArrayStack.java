package org.example.Stack;

import org.example.array.DynamicArray;

public class ArrayStack<E> implements Stack<E> {
    DynamicArray<E> array;
    public ArrayStack(int capacity) {
        array = new DynamicArray<>(capacity);
    }

    public ArrayStack() {
        array = new DynamicArray<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() throws Exception{
        return array.removeLast();
    }

    @Override
    public E peek() throws Exception {
        return array.getLast();
    }

    @Override
    public String toString()  {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
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
}
