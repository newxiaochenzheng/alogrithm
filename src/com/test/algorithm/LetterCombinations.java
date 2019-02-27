package com.test.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        //核心方式为递归
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }

        result.add("");
        String[] charMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i++) {
            result = combine(charMap[digits.charAt(i) - '0'], result);
        }
        return result;

    }

    private List<String> combine(String digit, List<String> l) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < digit.length(); i++) {
            for (String x : l) {
                result.add(x + digit.charAt(i));
            }
        }
        return result;
    }
}
