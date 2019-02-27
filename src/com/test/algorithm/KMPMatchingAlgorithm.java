package com.test.algorithm;

public class KMPMatchingAlgorithm {
    public static void main(String[] args) {
        String txt = "AAAAABAAABA";
        String pat = "AAAA";
        new KMPMatchingAlgorithm().kmpSearch(pat, txt);
    }

    public void kmpSearch(String pat, String txt) {
        int[] lps = new int[pat.length()];
        computeLPSArray(pat, lps);
        int m = pat.length();
        int n = txt.length();

        int i = 0;
        int j = 0;
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                System.out.println("found start index:" + (i - j));
                j = lps[j - 1];
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    private void computeLPSArray(String pat, int[] lps) {
        int i = 1;
        lps[0] = 0;
        int len = 0;
        int m = pat.length();
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
    }
}
