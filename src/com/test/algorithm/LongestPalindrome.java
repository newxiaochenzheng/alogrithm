package com.test.algorithm;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "asdflajdfljalfjafakfkasjfasfadjfasljdflasdfjwjekrjwkjrlwr";
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        long start = System.nanoTime();
        System.out.println(longestPalindrome.longestPalindrome1(s));
        System.out.println("e1:" + (System.nanoTime() - start));

         start = System.nanoTime();
        System.out.println(longestPalindrome.longestPalindrome2(s));
        System.out.println("e2:" + (System.nanoTime() - start));

    }

    private int start = 0;
    private int maxLen = 1;

    public String longestPalindrome1(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            centralDiffusion(s, i, i);
            centralDiffusion(s, i, i + 1);
        }
        return s.substring(start, start + maxLen);
    }

    /**
     * 遍历求解方式，最容易理解
     *
     * @param s
     * @param i
     * @param j
     */
    private void centralDiffusion(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (maxLen < j - i - 1) {
            maxLen = j - i - 1;
            start = i + 1;
        }

    }

    public String longestPalindrome2(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i - maxLen - 1, i)) {
                start = i - maxLen - 1;
                maxLen += 2;
            } else if (isPalindrome(s, i - maxLen, i)) {
                start = i - maxLen;
                maxLen += 1;
            }
        }
        return s.substring(start, start + maxLen);
    }


    private boolean isPalindrome(String s, int i, int j) {
        if (i < 0) {
            return false;
        }
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }


}
