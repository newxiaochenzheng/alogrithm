package com.test.design.wrapper.wrapperinner;

public class Activity extends ContextThemeWrapper {

    @Override
    public void attach(Context base) {
        super.attach(base);
    }

    @Override
    public void startActivity() {
        super.startActivity();
        System.out.println("Activity startActivity");
    }
}
