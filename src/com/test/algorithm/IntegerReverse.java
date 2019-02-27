package com.test.algorithm;

public class IntegerReverse {
    public static void main(String[] args) {
        System.out.println(new IntegerReverse().reverse(123453453));
//        System.out.println((-1107) % 10);
    }
//
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            //% / 后符号位都没有改变！！！
            int newResult = result * 10 + x % 10;
            //精度丢失了，如果数字太大，减去再除以，不等于原来的数，写成这样你就懂了。
            // if(((result*10 + a) - a) / 10 != result ){
            // return 0;
            //}
            if ((newResult - x % 10) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }

//    public int reverse(int x) {
//        int result = 0;
//        while (x != 0) {
//            int tail = x % 10;
//            int newResult = result * 10 + tail;
//            if ((newResult - tail) / 10 != result) {
//                return 0;
//            }
//            x = x / 10;
//            result = newResult;
//        }
//        return result;
//    }
}
