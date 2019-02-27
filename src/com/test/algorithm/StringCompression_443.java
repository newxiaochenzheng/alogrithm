package com.test.algorithm;

public class StringCompression_443 {
    public static void main(String[] args) {
        char[] array = {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'};
        System.out.println(new StringCompression_443().compress(array));
        System.out.println(array);
    }

    public int compress(char[] chars) {
        int index = 0;
        int indexAns = 0;
        while (index < chars.length) {
            int count = 0;
            char currentChar = chars[index];
            while (index < chars.length && chars[index] == currentChar) {
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[indexAns++] = c;
                }
            }
        }
        return indexAns;

    }

    private char[] getIntegerLength(int count) {
        char[] chars;
        if (count == 1000) {
            chars = new char[]{'1', '0', '0', '0'};
        } else if (count >= 100) {
            chars = new char[3];
            chars[0] = (char) ('0' + count / 100);
            count = count % 100;
            chars[1] = (char) ('0' + count / 10);
            count = count % 10;
            chars[2] = (char) ('0' + count);

        } else if (count >= 10) {
            chars = new char[2];
            chars[0] = (char) ('0' + count / 10);
            count = count % 10;
            chars[1] = (char) ('0' + count);
        } else {
            chars = new char[1];
            chars[0] = (char) ('0' + count);
        }
        return chars;
    }
}
