package org.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public class DynamicArray<E> {
    private E[] data;
    private int size;
    private static int default_capacity = 10;

    // 构造函数, 纯如数组容量capacity构造Array
    public DynamicArray(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    // 默认构造函数
    public DynamicArray() {
        this(default_capacity);
    }

    // 获取数组中元素个数
    public int getSize() {
        return size;
    }

    // 获取数组容量
    public int getCapacity() {
        return data.length;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在数组最后添加元素
     * @param e
     */
    public void addLast(E e) {
        // check data length.
        addIndex(size, e);
    }

    public void addFirst(E e) {
        addIndex(0, e);
    }

    public void addIndex(int index, E e) {
        if (index < 0 || index > size)
            return;
        if (size == data.length) resize(2 * data.length);

        for (int i = size-1; i>=index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }

    // 获取index索引位置的元素
    public E get(int index) throws Exception{
        if (index < 0 || index >= size) throw new Exception("error.");
        return data[index];
    }

    void set(int index, E e) {
        if (index < 0 || index >= size) return ;
        data[index] = e;
    }

    // 查找数组中是否包含元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) return true;
        }
        return false;
    }

    /**
     * 查找数组中是否包含元素e, 若包含, 返回e所在的索引位置, 否则返回-1
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) return i;
        }
        return -1;
    }

    public E getLast() throws Exception{
        return get(size-1);
    }

    public E getFirst() throws Exception {
        return get(0);
    }

    /**
     * 从数组中删除元素, 并返回该位置的元素
     * @return
     */
    public E remove(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("e");
        }

        E ret = data[index];
        for (int i = index+1; i < size; i++)
            data[i-1] = data[i];
        size--;
        data[size] = null; // 完成GC

        if (size == data.length/4 && data.length/2 != 0)
            resize(data.length / 2);
        return ret;
    }

    public E removeFirst() throws Exception{
        return remove(0);
    }

    public E removeLast() throws Exception{
        return remove(size-1);
    }

    /**
     * 删除指定元素, 只删除一个元素
     */
    public void removeElement(E e) throws Exception {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i<size; i++) {
            res.append(data[i]);
            if (i != size-1)
                res.append(",");
        }
        res.append("]");
        return res.toString();
    }
}
