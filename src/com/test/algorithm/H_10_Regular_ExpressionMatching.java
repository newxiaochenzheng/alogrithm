package com.test.algorithm;

public class H_10_Regular_ExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (s.equals(p)) {
            return true;
        }
        int i = 0;
        int j = 0;
        while (i < s.length() && j < p.length()) {
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                i++;
                j++;
            } else if (p.charAt(j) == '*') {
                if (i == 0 || j == 0) {
                    return false;
                }
                if (s.charAt(i - 1) != p.charAt(j - 1)) {
                    j++;
                    continue;
                }
                if (p.charAt(j - 1) == '.') {
                    return true;
                }
                if (s.charAt(i - 1) == s.charAt(i)) {
                    i++;
                } else if (++j == p.length()) {
                    return false;
                } else {
                    if (s.charAt(i) != p.charAt(j)) {
                        return false;
                    }
                }

            }
        }
        return i == s.length();
    }


    public boolean matchRegex(char[] text, char[] pattern) {
        String st = "ab";
        boolean T[][] = new boolean[text.length + 1][pattern.length + 1];
        T[0][0] = true;
        //deal with a*b*c*
        for (int i = 1; i < pattern.length; i++) {
            if (pattern[i] == '*' && T[0][i - 1]) {
                T[0][i + 1] = true;
            }
        }
        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
                    T[i][j] = T[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    T[i][j] = T[i][j - 2];
                    if (pattern[j - 2] == '.' || pattern[j - 2] == text[i - 1]) {
                        T[i][j] = T[i][j] | T[i - 1][j];
                    }
                }
            }
        }
        return T[text.length][pattern.length];
    }

    private void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int start = low;
        int end = high;

        int pivot = array[start];
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
            SortUtil.swap(array, low, start);
        }

        quickSort(array, low, start - 1);
        quickSort(array, start + 1, high);

    }

    public static void main(String[] args) {
        int[] nums = {1,34,5,6,6,-6,7,7,8,8};
        new H_10_Regular_ExpressionMatching().quickSort(nums,0,nums.length-1);
        SortUtil.print(nums);
    }


}
