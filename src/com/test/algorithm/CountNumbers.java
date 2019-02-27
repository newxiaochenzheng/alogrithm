package com.test.algorithm;

public class CountNumbers {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 2, 3};
        System.out.println(countNumbers(array, array.length, 3, 3));
    }

    private static int countNumbers(int[] array, int n, int x, int y) {
        if (y < x) {
            return n;
        }
        int count1 = 0;
        int count2 = 0;
        for (int value : array) {
            if (value + y <= x) {
                count1++;
            } else if (value <= x) {
                count2++;
            }
        }
        return count1 + (count2 + 1) / 2;
    }
}
