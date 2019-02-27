package com.test.algorithm;

public class SingleIntValue {
    public static void main(String[] args) {
        int[] array = {34, 34, 5, 5, 6, 9, 6, 7, 7};
        System.out.println(getSingle(array));
    }

    public static int getSingle(int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result ^= array[i];

        }
        return result;
    }
}
