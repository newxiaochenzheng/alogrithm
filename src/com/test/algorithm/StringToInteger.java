package com.test.algorithm;

public class StringToInteger {
    public int myAtoi(String str) {
        int index = 0;
        int sign = 1;
        int total = 0;
        if (str.length() == 0 || str.trim().length() == 0) {
            return 0;
        }
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        if (index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }

            int result = total * 10 + digit;
            if ((result - digit) / 10 != total) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            total = result;
            index++;
        }
        return sign < 0 ? -total : total;
    }
}
