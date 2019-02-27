package com.test.algorithm;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strings = {"aca", "cba"};
        new LongestCommonPrefix().longestCommonPrefix(strings);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
