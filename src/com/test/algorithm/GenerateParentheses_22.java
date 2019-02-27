package com.test.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses_22 {
    public List<String> generateParenthesis(int n) {
        List<String>[] lists = new ArrayList[n + 1];
        return helper(n, lists);
    }


    private List<String> helper(int n, List<String>[] lists) {
        if (lists[n] != null) {
            return lists[n];
        }
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            lists[0] = new ArrayList<>(Arrays.asList(""));
            return lists[0];
        }
        if (n == 1) {
            lists[1] = new ArrayList<>(Arrays.asList("()"));
            return lists[1];
        }
        //p(n) = p(n-i-1)*p(i)
        for (int i = 0; i < n; i++) {
            List<String> left = helper(n - i - 1, lists);
            List<String> inside = helper(i, lists);
            for (String str1 : left) {
                for (String str2 : inside) {
                    result.add(str1 + "(" + str2 + ")");
                }
            }
        }
        lists[n] = result;
        return result;

    }
}
