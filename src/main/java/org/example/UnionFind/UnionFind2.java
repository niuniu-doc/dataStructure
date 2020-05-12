package org.example.UnionFind;

import java.util.Random;

public class UnionFind2 implements UF {
    private int[] parent; // 第i个元素指向哪个节点

    public UnionFind2(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i; // 初始化、将每个节点指向自身, 都是独立的树
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

        parent[pRoot] = qRoot; // 否则、将p的根节点指向q的根节点
    }

    public static void main(String[] args) {
        int size = 100000;
        int m = 10000;

        UnionFind1 uf1 = new UnionFind1(size);
        System.out.println("uf1: " + testUF(uf1, m) + " s");

        UnionFind1 uf2 = new UnionFind1(size);
        System.out.println("uf1: " + testUF(uf2, m) + " s");
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

