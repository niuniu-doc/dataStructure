package org.example.UnionFind;

public interface UF {
    int getSize();
    boolean isConnected(int p, int q);
    void UnionElements(int p, int q);
}
