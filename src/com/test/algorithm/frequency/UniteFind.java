package com.test.algorithm.frequency;

public class UniteFind {
    final int N = 100;
    int[] pre = new int[N];
    int[] r = new int[N];//表示自己与跟节点的关系：0，同类；1，不同类

    public void init() {
        for (int i = 0; i < N; i++) {
            pre[i] = i;
            r[i] = 0;
        }
    }

    private int findPre(int x) {
        if (pre[x] == x) {
            return x;
        }
        int t = pre[x];
        pre[x] = findPre(pre[x]);
        r[x] = (r[x] + r[t]) % 2;
        return pre[x];
    }

    private void unite(int x, int y) {
        int fx = findPre(x);
        int fy = findPre(y);
        pre[fx] = fy;
        r[fx] = (r[x] + r[y] + 1) % 2;
    }
}
