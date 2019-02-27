package com.test.design.single;

public class SingleMain {
    public static void main(String[] args) {
        long curTimes = System.currentTimeMillis();
        long nanoSeconds = System.nanoTime();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long dif1 = System.currentTimeMillis()-curTimes;
        long dif2 = System.nanoTime()-nanoSeconds;
        System.out.println("cur=" + dif1);
        System.out.println("nanoSeconds=" + dif2);
    }
}
