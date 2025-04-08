package com.test.algorithm;

public class TopKMax {

    public static void main(String[] args) {
        int[] array = {1, 2, 23, 4, 5, 5, 6, 7, 8, -4, 5, 6, 7};
        int[] result = new TopKMax().topKMax(array, 5);
        SortUtil.print(result);
    }

    private int[] topKMax(int[] array, int k) {
        if (k >= array.length) {
            return array;
        }
        int[] kArray = new int[k];
        System.arraycopy(array, 0, kArray, 0, k);
        buildHeap(kArray);
        for (int i = k; i < array.length; i++) {
            if (kArray[0] < array[i]) {
                kArray[0] = array[i];
                adjustHeap(kArray, 0, k);
            }
        }

        return kArray;

    }

    private void buildHeap(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length);
        }

    }

    private void adjustHeap(int[] array, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int root = i;
        if (left < len && array[left] < array[root]) {
            root = left;
        }
        if (right < len && array[right] < array[root]) {
            root = right;
        }
        if (root != i) {
            SortUtil.swap(array, root, i);
            adjustHeap(array, root, len);
        }
    }

}
