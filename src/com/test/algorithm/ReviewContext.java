package com.test.algorithm;

import java.util.HashMap;

public class ReviewContext {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
//        if (l1.val < l2.val) {
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        } else {
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        }

        ListNode head = new ListNode(0);
        ListNode dumpy = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dumpy.next = l1;
                l1 = l1.next;
            } else {
                dumpy.next = l2;
                l2 = l2.next;
            }
            dumpy = dumpy.next;
        }
        if (l1 != null) {
            dumpy.next = l1;
        } else {
            dumpy.next = l2;
        }
        return head;
    }


}

class Lurcache {
    private int capacity;
    private HashMap<Integer, InnerNode> map;
    private int count;
    private InnerNode head;
    private InnerNode tail;

    public Lurcache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        head = new InnerNode(0, 0);
        tail = new InnerNode(0, 0);
        head.pre = null;
        head.next = tail;
        tail.pre = head;
        tail.next = null;

    }

    private void deleteNode(InnerNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;

    }

    private void addToHead(InnerNode node) {
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
    }

    public void set(int key, int value) {
        InnerNode node = map.get(key);
        if (node == null) {
            node = new InnerNode(key, value);
            map.put(key, node);
            if (count < capacity) {
                count++;
                addToHead(node);
            } else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        } else {
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }
    }

    public int get(int key) {
        InnerNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        deleteNode(node);
        addToHead(node);
        return node.value;
    }

}

class Solution_200 {
    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    searchAround(grid, i, j);
                }
            }
        }
        return count;
    }

    private void searchAround(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        searchAround(grid, i, j - 1);
        searchAround(grid, i - 1, j);
        searchAround(grid, i, j + 1);
        searchAround(grid, i + 1, j);
    }
}

class InnerNode {
    InnerNode pre;
    InnerNode next;
    int key;
    int value;

    InnerNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
