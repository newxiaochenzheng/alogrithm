package com.test.design.wrapper.wrapperinner;

public class ContextWrapper extends Context {
    private Context mBase;

    public ContextWrapper(Context base) {
        mBase = base;
    }

    public void attach(Context base) {
        mBase = base;
    }

    @Override
    public void startActivity() {
        mBase.startActivity();
    }

    @Override
    public void startService() {
        mBase.startService();
    }
}
