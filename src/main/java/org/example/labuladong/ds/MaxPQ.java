package org.example.labuladong.ds;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq; //存储元素
    private int n; // 当前q中元素个数

    public MaxPQ(int cap) {
        pq = (Key[])new Comparable[cap+1]; // 第一个节点不存储元素
    }

    private int parent(int root) {
        return root/2;
    }

    private int left(int root) {
        return 2*root;
    }

    private int right(int root) {
        return 2*root + 1;
    }

    public Key max() {
        return pq[1];
    }

    /**
     * 插入元素, 直接放在最后、然后上浮至合适位置
     * @param e
     */
    public void insert(Key e) {
        n++;
        pq[n] = e;
        swim(n);
    }

    /**
     * 删除并返回最大元素, 将堆顶元素A与堆低元素B对调, 删除A, 将B下沉至合适位置
     * @return
     */
    public Key delMax() {
        Key max = pq[1];
        exch(1, n);
        pq[n] = null;
        n--;
        skin(1);
        return max;
    }

    /**
     * 上浮操作
     */
    public void swim(int k) {
        while (k>1 && less(parent(k), k)) {
            exch(parent(k), k);
            k = parent(k);
        }
    }

    /**
     * 下沉操作
     * 若比左右子节点都大、无需下沉; 否则与左右节点中较大者交换
     */
    public void skin(int k) {
        while (left(k)<=n) {
            int older = left(k);
            if (k<n&&less(older, right(k)))
                older = right(k);

            if (less(older, k)) break;
            exch(k, older);
            k = older;
        }
    }

    // 交换元素
    private void exch(int i, int j) {
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }
}
