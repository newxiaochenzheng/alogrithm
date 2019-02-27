package com.test.design.wrapper.wrapperinner;

public class Service extends ContextWrapper {
    public Service() {
        super(null);
    }

    @Override
    public void attach(Context base) {
        super.attach(base);
    }

    @Override
    public void startService() {
        super.startService();
        System.out.println("Service startService");

    }
}
