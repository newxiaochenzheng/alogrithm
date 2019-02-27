package com.test.algorithm.frequency;

public class UnionFind {
    int[] pre = new int[100];
    int[] rank = new int[100];

    private void union(int i, int j) {
        i = pre[i];
        j = pre[j];
        if (i == j) {
            return;
        }
        if (rank[i] > rank[j]) {
            pre[j] = i;
        } else {
            if (rank[i] == rank[j]) rank[j]++;
            pre[i] = j;
        }
    }

    private int find_pre(int x) {
        if (pre[x] == x) {
            return x;
        }
        return pre[x] = find_pre(pre[x]);
    }

    boolean isSame(int x, int y) {
        return find_pre(x) == find_pre(y);
    }
}
