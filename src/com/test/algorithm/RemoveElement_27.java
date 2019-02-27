package com.test.algorithm;

public class RemoveElement_27 {
    public static void main(String[] args) {
        int[] array = {4,4,4,4,4};
        System.out.println(new RemoveElement_27().removeElement(array, 4));
    }

    public int removeElement(int[] A, int elem) {
        int len = A.length;
        for (int i = 0 ; i< len; ++i){
            while (A[i]==elem && i< len) {
                A[i]=A[--len];
            }
        }
        return len;
    }
}
