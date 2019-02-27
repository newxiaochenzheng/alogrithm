package com.test.design.single;

public class Singleton {
    /**
     * 静态内部类方式，缺点：无法传递参数
     * dcl：double check lock 方式为懒汉式模式，可以进行传递参数
     */
    private static class InnerClass {
        private static Singleton sInstance = new Singleton();
    }

    public static Singleton getInstance() {
        return InnerClass.sInstance;
    }

    private Singleton() {

    }
}
