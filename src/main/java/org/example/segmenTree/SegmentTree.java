package org.example.segmenTree;

import java.util.Arrays;

public class SegmentTree<E> {
    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }

        tree = (E[])new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    // 再treeIndex的位置创建表示区间[l...r]的线段树
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r-l)/2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid+1, r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            System.out.println("get error.");
        }
        return data[index];
    }

    // 返回完全二叉树的数组表示中、一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length ||
            queryR < 0 || queryR >= data.length ||
            queryL > queryR) {
            System.out.println("query error.");
            return null;
        }
        return query(0, 0, data.length-1,queryL, queryR);
    }

    // 在以treeIndex为根的线段树种[l...r]的范围里, 搜索区间[queryL...queryR]的值
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int mid = l + (r-l)/2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (queryL >= mid + 1) {
            return query(rightTreeIndex, mid+1, r, queryL, queryR);
        } else if (queryR <= mid){
            return query(leftTreeIndex, l, mid, queryL, queryR);
        } else {
            // 跨两个区间
            E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
            E rightResult = query(rightTreeIndex, mid+1, r, mid+1, queryR);
            E res = merger.merge(leftResult, rightResult);
            return res;
        }
    }

    public void set(int index, E e) {
        if (index < 0 || index > data.length) {
            System.out.println("set error.");
        }

        data[index] = e;
        set(0, 0, data.length-1, index, e);
    }

    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l==r) {
            tree[treeIndex] = e;
            return;
        }
        int mid = l + (r-l)/2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (index >= mid+1) {
            set(rightTreeIndex, mid+1, r, index, e);
        } else { // index<mid
            set(leftTreeIndex, l, mid, index, e);
        }
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        return "SegmentTree{" +"\n" +
                "tree=" + Arrays.toString(tree) + "\n" +
                ", data=" + Arrays.toString(data) + "\n" +
                ", merger=" + merger +"\n" +
                '}';
    }

    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, 5, 2, -1};
        SegmentTree<Integer> segTree = new SegmentTree<>(nums, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a+b;
            }
        });
        //SegmentTree<Integer> segTree = new SegmentTree<>(nums, (a, b)->a+b);
        System.out.println(segTree);

        System.out.println(segTree.query(0,2));
        System.out.println(segTree.query(2,5));
        System.out.println(segTree.query(0,5));
    }
}
