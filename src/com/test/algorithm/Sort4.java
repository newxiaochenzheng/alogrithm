package com.test.algorithm;

public class Sort4 {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {4,5};
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }

}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedNums = new int[nums1.length + nums2.length];
        int p = 0;
        int q = 0;
        int i = 0;
        while (p < nums1.length && q < nums2.length) {
            if (nums1[p] < nums2[q]) {
                mergedNums[i++] = nums1[p++];
            } else {
                mergedNums[i++] = nums2[q++];
            }
        }
        while(p<nums1.length){
            mergedNums[i++] = nums1[p++];

        }
        while(q<nums2.length){
            mergedNums[i++] = nums2[q++];

        }
        int length = mergedNums.length;
        for(int value:mergedNums){
            System.out.println(value);
        }
        if (length % 2 == 0) {
            int a = mergedNums[length / 2 - 1];
            int b = mergedNums[length / 2];
            return (double) (a + b)/2;
        } else {
            return (double) mergedNums[length / 2];
        }
    }

}
