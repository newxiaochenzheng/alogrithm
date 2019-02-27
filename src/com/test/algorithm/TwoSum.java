package com.test.algorithm;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int[] result = new int[2];
        if (nums.length == 2) {
            if (nums[0] + nums[1] == target) {
                return new int[]{0, 1};
            } else {
                return result;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int value = map.get(target - nums[i]);
                if (i != value) {
                    result[0] = i;
                    result[1] = value;
                    return result;
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
