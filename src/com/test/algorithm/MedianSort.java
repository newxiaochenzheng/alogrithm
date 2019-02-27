package com.test.algorithm;

public class MedianSort {


    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 5};
        int[] nums2 = {2, 6, 7, 8, 9};
        double median = getMedian(nums1, nums2);
        System.out.println(median);
    }

    private static double getMedian(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (getKthMedianNew1(nums1, 0, m - 1, nums2, 0, n - 1, left)
                + getKthMedianNew1(nums1, 0, m - 1, nums2, 0, n - 1, right)) * 0.5;

    }

    private static double getKthMedianNew1(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1;
        int len2 = end2 - start2;
        if (len1 > len2) {
            getKthMedian(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int index1 = start1 + Math.min(k / 2, len1) - 1;
        int index2 = start2 + Math.min(k / 2, len2) - 1;
        if (nums1[index1] < nums2[index2]) {
           return getKthMedian(nums1, index1 + 1, end1, nums2, start2, end2, k - (index1 - start1 + 1));
        } else {
           return getKthMedian(nums1, start1, end1, nums2, index2, end2, k - (index2 - start2 + 1));
        }
    }

    private static int getKthMedian(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 > len2) {
            return getKthMedian(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int i = start1 + Math.min(k / 2, len1) - 1;
        int j = start2 + Math.min(k / 2, len2) - 1;
        if (nums1[i] < nums2[j]) {
            return getKthMedian(nums1, i + 1, end1, nums2, start2, end2, k - (i + 1 - start1));
        } else {
            return getKthMedian(nums1, start1, end1, nums2, j + 1, end2, k - (j + 1 - start2));
        }

    }


}
