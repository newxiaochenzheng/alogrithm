package com.test.algorithm;

/**
 * https://www.geeksforgeeks.org/time-complexity-of-building-a-heap/
 */
public class HeapTest {
    public static void main(String[] args) {
        int[] array = {4, 5, -6, 7, 9, 8};
        heapSort(array);
        print(array);
    }

    private static void print(int[] array) {
        for (int value : array) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }

    public static void heapSort(int[] array) {
        buildHeap(array);
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            adjustHeap(array, 0, i);
        }

    }


    private static void buildHeap(int[] array) {
        int len = array.length;
        if (len <= 1) {
            return;
        }
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, len);
        }

    }

    private static void adjustHeap(int[] array, int i, int len) {
        int nodeIndex = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < len && array[left] > array[nodeIndex]) {
            nodeIndex = left;
        }
        if (right < len && array[right] > array[nodeIndex]) {
            nodeIndex = right;
        }
        if (nodeIndex != i) {
            swap(array, nodeIndex, i);
            adjustHeap(array, nodeIndex, len);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
