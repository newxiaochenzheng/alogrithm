package com.test.algorithm;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
    public static void main(String[] args) {
        String s = "abcdefg13jkjkkskflklklkj";
        System.out.println(getLongestSubStringNew1(s));
        System.out.println(getLongestSubString(s));

    }

    private static int getLongestSubStringNew1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    private static int getLongestSubString(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                //j不能往回退
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

}
