package com.test.design.wrapper.inner;

public class InnerMain {
    public static void main(String[] args) {
        UnitContext context = new UnitContextImpl();
        UnitConcrete1 concrete1 = new UnitConcrete1();
        concrete1.attach(context);
        concrete1.operation();
    }
}
