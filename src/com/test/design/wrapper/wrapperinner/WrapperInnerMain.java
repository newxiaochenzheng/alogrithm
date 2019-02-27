package com.test.design.wrapper.wrapperinner;

public class WrapperInnerMain {
    public static void main(String[] args) {
        Context base = new ContextImpl();
        Activity activity = new Activity();
        activity.attach(base);
        activity.startActivity();
        Service service = new Service();
        service.attach(base);
        service.startService();
    }
}
