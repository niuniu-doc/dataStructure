package org.example.heap;

import org.example.array.DynamicArray;

import java.util.Random;

/**
 * 最大堆
 */
public class MaxHeap<E extends  Comparable<E>> {
    private DynamicArray<E> data;

    // 构造函数
    public MaxHeap() {
        data = new DynamicArray<>();
    }

    public MaxHeap(int capacity) {
        data = new DynamicArray<>(capacity);
    }

    /**
     * 将任意数组整理成堆的形状
     * 1. 扫描数组、逐个添加到堆中
     * 2. 从最后一个非叶子节点开始shiftDown操作
     *    从最后一个节点的索引计算其父节点索引即可
     */
    public MaxHeap(E[] arr) {
        data = new DynamicArray<>(arr);
        for (int i = parent(arr.length - 1); i >= 0 ; i--) {
            shiftDown(i);
        }
    }


    public int size() {
        return data.getSize();
    }

    // 堆是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中、一个索引所表示的元素的父节点的索引
    private int parent(int index) {
        if (index == 0) System.out.println("index-0 parent error");
        return (index-1)/2;
    }

    private int leftChild(int index) {
        return 2*index + 1;
    }

    private int rightChild(int index) {
        return 2*index + 2;
    }

    // 向堆中添加元素(Sift Up)
    public void add(E e) {
        data.addLast(e); // 直接向数组末尾添加元素、然后调整元素位置
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(parent(k), k);
            k = parent(k); // 继续往上比较
        }
    }

    public E findMax() {
        if (data.getSize() == 0) System.out.println("findMax error");
        return data.get(0);
    }

    // 从堆中取出元素
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        shiftDown(0);

        return ret;
    }

    private void shiftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j+1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
                // data[j] 是 max(leftChild, rightChild);
            }

            if (data.get(k).compareTo(data.get(j)) >= 0) break;
            data.swap(k, j); // 交换k和j的数据
            k = j; // 继续下沉
        }
    }

    /**
     * replace:
     * 1. 先extractMax, 再add, 需要两次 O(log n)
     * 2. 直接替换
     */
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        shiftDown(0);
        return e;
    }


    public static void main(String[] args) {
        int n = 2;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i-1] < arr[i]) {
                System.out.println("maxHeap error.");
            }
        }

        System.out.println("test maxHeap competed.");
    }

    private static double testHeap(Integer[] testData, boolean isHeapify) {
        long starTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<>(testData);
        } else {
            maxHeap = new MaxHeap<>();
            for (int num : testData) {
                maxHeap.add(num);
            }
        }
        long endTime = System.nanoTime();

        System.out.println("useTime: " + (endTime - starTime)/100000000.0 + " s");
    }
}
