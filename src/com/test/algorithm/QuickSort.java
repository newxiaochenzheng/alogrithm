package com.test.algorithm;

import javax.rmi.CORBA.Util;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {3, -3, 9, 6, 7, 7, 8, 8, 1, 342, 3423, 4};
//        quickSort(array, 0, array.length - 1);
//        bubbleSort(array, 0, array.length - 1);
//        selectionSort(array, 0, array.length - 1);
//        insertSort(array, 0, array.length - 1);
//        shellSort(array, 0, array.length - 1);
        heapSort(array);
        SortUtil.print(array);
    }

//    private static void quickSort(int[] array, int start, int end) {
//        if (start >= end) {
//            return;
//        }
//        int pivot = array[end];
//        int left = start;
//        int right = end;
//        while (left < right) {
//
//            while (array[left] < pivot && left < right) {
//                left++;
//            }
//            while (array[right] >= pivot && left < right) {
//                right--;
//            }
//            if (left < right) {
//                SortUtil.swap(array, left, right);
//            }
//        }
//
//        SortUtil.swap(array, left, end);
//        quickSort(array, start, left - 1);
//        quickSort(array, left + 1, end);
//    }

    //1
    private static void quickSort(int[] array, int start, int end) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        stack.push(end);
        while (!stack.isEmpty()) {
            int right = stack.pop();
            int left = stack.pop();
            int index = partialSort(array, left, right);
            if (index - 1 > left) {
                stack.push(left);
                stack.push(index - 1);
            }
            if (index + 1 < right) {
                stack.push(index + 1);
                stack.push(right);
            }
        }
    }

    private static int getShortestSubString(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    private static int partialSort(int[] array, int start, int end) {
        int pivot = array[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && array[right] > pivot) {
                right--;
            }
            while (left < right && array[left] <= pivot) {
                left++;
            }
            if (left < right) {
                SortUtil.swap(array, left, right);
            }
        }
        if (start != right) {
            SortUtil.swap(array, start, right);
        }
        return right;

    }

    //2
    private static void bubbleSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int len = end - start + 1;
        for (int i = 0; i < len - 1; i++) {
            for (int j = start; j < end - i; j++) {
                if (array[j] > array[j + 1]) {
                    SortUtil.swap(array, j, j + 1);
                }
            }
        }
    }

    //3
    private static void selectionSort(int[] array, int start, int end) {
        for (int i = start; i <= end; i++) {
            int mix = i;
            for (int k = i + 1; k <= end; k++) {
                if (array[k] < array[mix]) {
                    mix = k;
                }
            }
            if (mix != i) {
                SortUtil.swap(array, mix, i);
            }
        }

    }

    //4注意保存待插入值
    private static void insertSort(int[] array, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int j = i - 1;
            int tmp = array[i];
            while (j >= start && array[j] > tmp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;

        }
    }

    //5插入排序的改进
    private static void shellSort(int[] array, int start, int end) {
        for (int gap = (end - start) / 3; gap >= 1; gap--) {
            for (int i = start + gap; i <= end; i = i + gap) {
                int j = i - gap;
                int tmp = array[i];
                while (j >= start && array[j] > tmp) {
                    array[j + gap] = array[j];
                    j = j - gap;
                }
                array[j + gap] = tmp;
            }
        }
    }

    //6
    private static void mergeSort(int[] array, int start, int end) {

    }

    //7
    private static void heapSort(int[] array) {
        int len = array.length;
        if (len <= 1) {
            return;
        }
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, len);
        }
        SortUtil.swap(array, 0, len - 1);
        for (int j = 1; j < len - 1; j++) {
            adjustHeap(array, 0, len - j - 1);
            SortUtil.swap(array, 0, len - j - 1);
        }
    }

    private static void adjustHeap(int[] array, int i, int len) {
        int pivot = i;
        int left = pivot * 2 + 1;
        int right = pivot * 2 + 2;
        if (left < len && array[left] > array[pivot]) {
            pivot = left;
        }
        if (right < len && array[right] > array[pivot]) {
            pivot = right;
        }
        if (pivot != i) {
            SortUtil.swap(array, pivot, i);
            adjustHeap(array, pivot, len);
        }
    }


    private int getMedian(int[] array1, int start1, int end1, int[] array2, int start2, int end2, int k) {
        int len1 = end1 - start1;
        int len2 = end2 - start2;
        if (len1 > len2) {
            return getMedian(array2, start2, end2, array1, start1, end1, k);
        }
        if (len1 == 0) {
            return array2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(array1[start1], array2[start2]);
        }
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        if (array1[i] < array2[j]) {
            return getMedian(array1, i + 1, end1, array2, start2, end2, k - (i + 1 - start1));
        } else {
            return getMedian(array1, start1, end1, array2, j + 1, end2, k - (j + 1 - start2));
        }
    }

    private float getMedianResult(int[] array1, int[] array2) {
        int m = array1.length;
        int n = array2.length;
        return (getMedian(array1, 0, array1.length - 1, array2, 0, array2.length - 1, (m + n + 1) / 2)
                + getMedian(array1, 0, array1.length - 1, array2, 0, array2.length - 1, (m + n + 2) / 2)) * 0.5f;

    }
}
