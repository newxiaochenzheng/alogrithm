package com.test.design.wrapper.inner;

public abstract class UnitContextWrapper implements UnitContext {
    private UnitContext base;


    @Override
    public void operation() {
        base.operation();
    }

    public void attach(UnitContext base) {
        this.base = base;
    }
}
