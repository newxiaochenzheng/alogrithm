package com.test.algorithm;

public class SortUtil {
    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

    }

    public static void print(int[] array) {
        for (int value : array) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }
}
