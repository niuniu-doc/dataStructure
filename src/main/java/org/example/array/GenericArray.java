package org.example.array;

import java.util.Arrays;

public class GenericArray<T> {
    private T[] data; // 数组
    private int size;

    public GenericArray(int capacity) {
        data = (T[])new Object[capacity];
        size = 0;
    }

    // 无参构造
    public GenericArray() {
        this(10);
    }

    // 获取数组容量
    public int getCapacity () {
        return data.length;
    }

    // 获取当前元素个数
    public int getSize() {
        return this.size;
    }

    // 判断数组是否为空
    public boolean isEmpty () {
        return size == 0;
    }

    // 修改index位置为元素
    public void set(int index, T e) {
        checkIndex(index);
        data[index] = e;
    }

    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    /**
     * check array isContains e/
     * @param e
     * @return
     */
    public boolean contains(T e) {
        for (int i=0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }

        return false;
    }


    /**
     * get index by e.
     * @return
     */
    public int find(T e) {
        for (int i=0; i<size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * insert e at index.
     * @return
     */
    public void add(int index, T e) {
        checkIndexForAdd(index);
        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size-1; i>=index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;

        size++;
    }

    /**
     * insert at first.
     * @return
     */
    public void addFirst(T e) {
        add(0, e);
    }

    /**
     * add at last.
     * @return
     */
    public void addLast(T e) {
        add(size, e);
    }

    /**
     * remove at index.
     * @return
     */
    public T remove(int index) {
        checkIndex(index);

        T ret = data[index];
        for (int i = index+1; i<size; i++) {
            data[i-1] = data[i];
        }
        size--;
        data[size] = null; // gc.

        // resize
        if (size == data.length / 4 && data.length/2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }

    /**
     * remove first
     * @return
     */
    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size-1);
    }

    @Override
    public String toString() {
        return "GenericArray{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    // 扩容方法、时间复杂度为 O(n)
    private void resize(int capacity) {
        T[] newData = (T[])new Object[capacity];

        for (int i=0; i<size; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add Failed. require index > 0 and < size");
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add Failed. require index > 0 and < size");
        }
    }
}
