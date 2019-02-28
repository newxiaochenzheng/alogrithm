package com.test.algorithm.frequency;

import com.test.algorithm.SortUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class M_904_Fruit_Into_Baskets {
    /**
     * https://stackoverflow.com/questions/49638176/time-complexity-of-find-the-longest-substring-with-k-unique-characters
     *
     * @param tree
     * @return 时间复杂度为O(n)，start和i索引都直往前走！！
     */
    public int totalFruit(int[] tree) {
        if (tree.length <= 2) {
            return tree.length;
        }
        return longestKUniqueSub(tree, 2);

    }

    private int longestKUniqueSub(int[] tree, int k) {
        if (k >=tree.length) {
            return tree.length;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(tree[0], 1);
        int result = 0;
        int start = 0;
        for (int i = 1; i < tree.length; i++) {
            if (map.containsKey(tree[i])) {
                map.put(tree[i], map.get(tree[i])+ 1);
            }else{
                map.put(tree[i], 1);
            }
            if (map.size() <= k) {
                result = Math.max(result, i - start + 1);
            } else {
                while (map.size() > k) {
                    int count = map.get(tree[start]);
                    if (count > 1) {
                        map.put(tree[start], count - 1);
                    } else {
                        map.remove(tree[start]);
                    }
                    start++;
                }
            }
        }
        return result;
    }

    public void quickSort(int[] array, int start, int end) {
//        if (end <= start) {
//            return;
//        }
//        int pivot = array[start];
//        int left = start;
//        int right = end;
//        while (left < right) {
//            while (left < right && array[right] > pivot) {
//                right--;
//            }
//            while (left < right && array[left] <= pivot) {
//                left++;
//            }
//            SortUtil.swap(array, left, right);
//        }
//        if (left != start) {
//            SortUtil.swap(array, start, left);
//        }
//        quickSort(array, start, left - 1);
//        quickSort(array, left + 1, end);
        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        stack.push(start);
        while (!stack.isEmpty()) {
            int left = stack.pop();
            int right = stack.pop();
            int low = left;
            int high = right;
            int pivot = array[left];
            while (left < right) {

                while (left < right && array[right] > pivot) {
                    right--;
                }
                while (left < right && array[left] <= pivot) {
                    left++;
                }
                SortUtil.swap(array, left, right);
            }
            if (left != low) {
                SortUtil.swap(array, left, low);

            }
            if (left - 1 > low) {
                stack.push(left - 1);
                stack.push(low);
            }
            if (left + 1 < high) {
                stack.push(high);
                stack.push(left + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, -3, 4, 3, 5, 6, 67, 7};
        new M_904_Fruit_Into_Baskets().quickSort(nums, 0, nums.length - 1);
        SortUtil.print(nums);
    }
}
