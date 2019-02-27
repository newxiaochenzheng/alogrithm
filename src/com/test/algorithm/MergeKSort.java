package com.test.algorithm;

/**
 * Merge k sorted nodess | Set 1
 * Given k sorted nodess of size n each, merge them and print the sorted output.
 * Example:
 * <p>
 * Input:
 * k = 3, n =  4
 * arr[][] = { {1, 3, 5, 7},
 * {2, 4, 6, 8},
 * {0, 9, 10, 11}} ;
 * <p>
 * Output: 0 1 2 3 4 5 6 7 8 9 10 11
 * <p>
 * https://www.geeksforgeeks.org/merge-k-sorted-arrays-set-2-different-sized-arrays/
 */
public class MergeKSort {
    public static void main(String[] args) {
        int arr[][] = {{1, 3, 5, 7}, {2, 4, 6, 8}, {0, 9, 10, 11}};
        int[] nodes = getMergedArray(arr);
        SortUtil.print(nodes);

    }

    private static int[] getMergedArray(int[][] arr) {
        HeapNode[] nodes = new HeapNode[arr.length];
        int k = arr.length;
        int n = arr[0].length;
        int count = k * n;
        for (int i = 0; i < k; i++) {
            HeapNode node = new HeapNode();
            node.element = arr[i][0];
            node.i = i;
            //这个地方有犯错，注意下！！
            node.j = 1;
            nodes[i] = node;
        }
        MinHeap heap = new MinHeap(nodes);
        int[] outArray = new int[count];

        for (int i = 0; i < count; i++) {
            HeapNode root = heap.getMin();
            outArray[i] = root.element;
            if (root.j < n) {
                root.element = arr[root.i][root.j];
                root.j++;
            } else {
                root.element = Integer.MAX_VALUE;
            }
            heap.replaceRootNode(root);

        }
        return outArray;
    }


}

class HeapNode {
    int element;
    int i;
    int j;
}

class MinHeap {
    private final HeapNode[] nodes;

    public MinHeap(HeapNode[] nodes) {
        this.nodes = nodes;
        createHeap();
    }

    private void createHeap() {
        for (int i = nodes.length / 2 - 1; i >= 0; i--) {
            adjustHeap(i, nodes.length);
        }
    }

    private void adjustHeap(int i, int len) {
        int min = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < len && nodes[left].element < nodes[min].element) {
            min = left;
        }
        if (right < len && nodes[right].element < nodes[min].element) {
            min = right;
        }
        if (min != i) {
            swapNode(min, i);
            adjustHeap(min, len);
        }
    }

    private void swapNode(int i, int j) {
        HeapNode tmp = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = tmp;
    }

    public HeapNode getMin() {
        if (nodes == null) {
            throw new IllegalArgumentException("please init nodes first");
        }
        return nodes[0];
    }

    public void replaceRootNode(HeapNode node) {
        nodes[0] = node;
        adjustHeap(0, nodes.length);
    }
}