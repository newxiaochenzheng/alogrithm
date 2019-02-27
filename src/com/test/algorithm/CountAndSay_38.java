package com.test.algorithm;

public class CountAndSay_38 {
    public static void main(String[] args) {
        System.out.println(new CountAndSay_38().countAndSay(6));

    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        int j = 2;
        StringBuilder sb = new StringBuilder("1");
        while (j <= n) {
            String output = sb.toString();
            int count = 1;
            sb.replace(0, sb.length(), "");
            char c = output.charAt(0);
            for (int i = 1; i < output.length(); i++) {
                if (c == output.charAt(i)) {
                    count++;
                } else {
                    sb.append(count).append(c);
                    count = 1;
                    c = output.charAt(i);
                }
            }
            sb.append(count).append(c);
            j++;
        }
        return sb.toString();
    }
}
