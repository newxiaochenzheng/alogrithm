package com.test.algorithm;

public class MedianSortNew {
    public static void main(String[] args) {

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int start1 = 0;
        int start2 = 0;
        int end1 = nums1.length - 1;
        int end2 = nums2.length - 1;
        int left = (nums1.length + nums2.length + 1) / 2;
        int right = (nums1.length + nums2.length + 2) / 2;
        int leftK = getKthMedian(nums1, start1, end1, nums2, start2, end2, left);
        int rightK = getKthMedian(nums1, start1, end1, nums2, start2, end2, right);
        return (leftK + rightK) / 2.0;
    }

    private int getKthMedian(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int length1 = end1 - start1 + 1;
        int length2 = end2 - start2 + 1;
        if (length1 > length2) {
            return getKthMedian(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (length1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int i = start1 + Math.min(length1, k / 2) - 1;
        int j = start2 + Math.min(length2, k / 2) - 1;
        if (nums1[i] < nums2[j]) {
            return getKthMedian(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        } else {
            return getKthMedian(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));

        }
    }
}
