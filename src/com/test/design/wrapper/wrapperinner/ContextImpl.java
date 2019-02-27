package com.test.design.wrapper.wrapperinner;

public class ContextImpl extends Context {
    @Override
    public void startActivity() {
        System.out.println("context Impl startActivity");
    }

    @Override
    public void startService() {
        System.out.println("context Impl startService");

    }
}
