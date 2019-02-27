package com.test.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        /**
         * 动态规划思想：将数据排序后，选定头，相当于求两个数之和，重复的自动过滤掉
         */
        if (nums.length < 3) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int sum = 0 - nums[i];
                int low = i + 1;
                int high = nums.length - 1;
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        lists.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < sum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }

        }
        return lists;

    }
}
