package com.test.algorithm.frequency;

public class BubbleTest {
    public static void main(String[] args) {
        int N = 100;
        int[][] array = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (j % i == 0) {
                    array[i][j]++;
                }
            }
        }
        int count = 0;
        for (int j = 1; j <= N; j++) {
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                sum += array[i][j];
            }

            if(sum%2!=0){
                count++;
                System.out.println("result"+j);
            }
        }
        System.out.println(count);
    }
}
