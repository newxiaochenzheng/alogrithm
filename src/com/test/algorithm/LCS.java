package com.test.algorithm;


import java.util.Random;

public class LCS {
    /**
     * 最长公共子序列需要考虑下两个队列不相等的情况，否则路径输出有问题。
     * @param args
     */
    public static void main(String[] args) {

        String x = "sff";
        String y ="sfsrff";
        if (x.length() < y.length()) {
            String tmp = x.intern();
            x = y;
            y = tmp;
        }

        int m = x.length();
        int n = y.length();
        int[][] c = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    c[i][j] = 0;
                    continue;
                }
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = Math.max( c[i][j - 1], c[i - 1][j]);
                }
            }
        }
        System.out.println("substring1:" + x);
        System.out.println("substring2:" + y);
        System.out.println(c[m][n]);
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print("\t" + c[i][j]);
            }
            System.out.println();
        }
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < x.length() && j < y.length()) {
            if (x.charAt(i) == y.charAt(j)) {
                sb.append(x.charAt(i));
                i++;
                j++;
            } else if (c[i + 1][j] >= c[i][j + 1]) {
                i++;
            } else {
                j++;
            }
        }
        System.out.println(sb.toString());

    }

    public static String getRandomStrings(int length) {
        String s = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        int range = s.length();
        for (int i = 0; i < length; i++) {
            sb.append(s.charAt(r.nextInt(range)));
        }
        return sb.toString();
    }
}
