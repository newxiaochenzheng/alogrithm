package com.test.algorithm;

public class PalindromeNumber {
    public boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        int len = s.length();
        if (len >= 2) {
            int i = len / 2 - 1;
            int j = len / 2 + (len % 2 == 0 ? 0 : 1);
            while (i >= 0 && j < len) {
                if (s.charAt(i--) != s.charAt(j++)) {
                    return false;
                }
            }
        }
        return true;

    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int p = x;
        int q = 0;
        while (p >= 10) {
            q = q * 10 + p % 10;
            p /= 10;
        }
        return p == x % 10 && q == x / 10;
    }
}
