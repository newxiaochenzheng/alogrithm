package com.test.algorithm.frequency;

import com.test.algorithm.H_10_Regular_ExpressionMatching;
import com.test.algorithm.SortUtil;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class H_407_Trapping_Rain_Water {


    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        int result = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            queue.offer(new int[]{heightMap[i][0], i, 0});
            visited[i][0] = true;
            queue.offer(new int[]{heightMap[i][n - 1], i, n - 1});
            visited[i][n - 1] = true;


        }
        for (int i = 1; i < n - 1; i++) {
            queue.offer(new int[]{heightMap[0][i], 0, i});
            visited[0][i] = true;
            queue.offer(new int[]{heightMap[m - 1][i], m - 1, i});
            visited[m - 1][i] = true;

        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir : directions) {
                int i = cell[1] + dir[0];
                int j = cell[2] + dir[1];
                if (i >= 0 && i < m && j >= 0 && j < n && !visited[i][j]) {
                    result += Math.max(0, cell[0] - heightMap[i][j]);
                    queue.offer(new int[]{Math.max(cell[0], heightMap[i][j]), i, j});
                    visited[i][j] = true;
                }
            }
        }
        return result;
    }


    private void quickSort(int[] array, int start, int end) {
        if (end <= start) {
            return;
        }
        int mid = part(array, start, end);
        quickSort(array, start, mid - 1);
        quickSort(array, mid + 1, end);

//        Stack<Integer> stack = new Stack<>();
//        stack.push(end);
//        stack.push(start);
//        while (!stack.isEmpty()) {
//            int left = stack.pop();
//            int right = stack.pop();
//            int low = left;
//            int high = right;
//            int pivot = array[low];
//            while (low < high) {
//                while (low < high && array[high] > pivot) {
//                    high--;
//                }
//                while (low < high && array[low] <= pivot) {
//                    low++;
//                }
//                SortUtil.swap(array, low, high);
//            }
//            if (low != left) {
//                SortUtil.swap(array, low, left);
//            }
//            if (low + 1 < right) {
//                stack.push(right);
//                stack.push(low + 1);
//            }
//            if (low - 1 > left) {
//                stack.push(low - 1);
//                stack.push(left);
//            }
//        }

    }

    private int part(int[] array, int low, int high) {
        if (low >= high) {
            return low;
        }
        int start = low;
        int end = high;
        int pivot = array[low];
        while (start < end) {
            while (start < end && array[end] > pivot) {
                end--;
            }
            while (start < end && array[start] <= pivot) {
                start++;
            }
            SortUtil.swap(array, start, end);
        }
        if (start != low) {
            SortUtil.swap(array, start, low);
        }
        return start;
    }

    public static void main(String[] args) {
//        int[] array = {1,24,4,5,6,-6,7,7,8,9};
//        new H_407_Trapping_Rain_Water().quickSort(array,0,array.length-1);
//        SortUtil.print(array);

//        String s1 = new String("1")+new String("1");
//        String s2 = "11";
//        System.out.println(s1 == s2);
//        String s3 = new String("a")+new String("a");
//        System.out.println(s3.intern() == "aa");

        String st = new String("hello world");
        String st2 = new String("hello world");
       String sss = st.intern();
        System.out.println(sss == st);
        System.out.println(st.intern() == st2.intern());
    }
}
