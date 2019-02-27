package com.test.algorithm;

public class ImplementStr_28 {
    public static void main(String[] args) {
        System.out.println(new ImplementStr_28().strStr("bba","ba"));
    }
    public int strStr(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0) {
            return 0;
        }
        if (needle == null || needle.length() == 0 || needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            char character = haystack.charAt(i);
            if (character == needle.charAt(0)) {
                int j = 1;
                i = i+1;
                boolean exist = true;
                while (j < needle.length() && i < haystack.length()) {
                    if (needle.charAt(j++) != haystack.charAt(i++)) {
                        exist = false;
                        break;
                    }
                }
                if (exist && j == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }
}
