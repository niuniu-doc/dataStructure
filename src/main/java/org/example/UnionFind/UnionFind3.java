package org.example.UnionFind;

import java.util.Random;

// 基于元素个数的优化
public class UnionFind3 implements UF {
    private int[] parent; // 第i个元素指向哪个节点
    private int[] sz; // sz[i] 表示以i为根的集合中元素个数

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i; // 初始化、将每个节点指向自身, 都是独立的树
            sz[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查看元素p和元素q是否同属于一个集合,
     * 时间复杂度: O(h), h为树的高度
     */
    private int find(int p) {
        if ( p < 0 || p >= parent.length) System.out.println("find error.");
        while (p != parent[p])
            p = parent[p]; // 查找元素对应的根节点所在的集合
        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void UnionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return; // 若两个元素的根节点是同一个节点, 本身就在同一集合中

        // 防止树过度退化
        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot]; // 维护元素
        }
    }

    public static void main(String[] args) {
        int size = 100000;
        int m = 10000;

        UnionFind1 uf1 = new UnionFind1(size);
        System.out.println("uf1: " + testUF(uf1, m) + " s");

        UnionFind2 uf2 = new UnionFind2(size);
        System.out.println("uf2: " + testUF(uf2, m) + " s");

        UnionFind3 uf3 = new UnionFind3(size);
        System.out.println("uf3: " + testUF(uf3, m) + " s");
    }

    private static double testUF(UF uf, int m) {
        int size = uf.getSize();
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.UnionElements(a, b);
        }
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }
        long endTime = System.nanoTime();

        return (endTime - startTime)/100000000.0;
    }
}

