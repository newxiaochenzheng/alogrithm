package com.test.algorithm;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return Integer.MAX_VALUE;
        }
        Arrays.sort(nums);
        int closet = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (Math.abs(sum - target) < Math.abs(closet - target)) {
                    closet = sum;
                }
                if (sum > target) {
                    high--;
                } else if (sum == target) {
                    return sum;
                } else {
                    low++;
                }
            }

        }
        return closet;
    }
}
