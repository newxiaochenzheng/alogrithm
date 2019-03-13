package com.test.design.wrapper.inner;

public class UnitConcrete1 extends UnitContextWrapper {
    public UnitConcrete1(UnitContext base) {
        attach(base);
    }

    public UnitConcrete1() {
        attach(null);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("concrete1 operation --->");
    }
}
