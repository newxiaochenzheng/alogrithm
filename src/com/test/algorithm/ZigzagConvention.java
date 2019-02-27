package com.test.algorithm;

public class ZigzagConvention {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        ZigzagConvention convention = new ZigzagConvention();
        System.out.println(convention.convert(s, 3));
    }

    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuilder[] builders = new StringBuilder[numRows];
        int increment = 1;
        int index = 0;
        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }
        for (int i = 0; i < s.length(); i++) {
            builders[index].append(s.charAt(i));
            if (index == 0) {
                increment = 1;
            }
            if (index == numRows - 1) {
                increment = -1;
            }
            index += increment;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder sb : builders) {
            stringBuilder.append(sb.toString());
        }
        return stringBuilder.toString();
    }
}
