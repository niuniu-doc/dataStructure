package org.example.UnionFind;

public class UnionFind1  implements UF {
    private int[] id;
    public UnionFind1(int size) {
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    // 查找元素p对应的集合编号
    private int find(int p) {
        if (p < 0 || p >= id.length) {
            System.out.println("find error.");
        }
        return id[p];
    }

    // 判断两个元素是否连通 O(1)
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 合并元素p和q所属的集合 O(n)
    @Override
    public void UnionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) return; // 本身就在同一个集合、可连通

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId)
                id[i] = qId;
        }
    }
}
