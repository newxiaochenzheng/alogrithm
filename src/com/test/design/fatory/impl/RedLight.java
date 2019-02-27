package com.test.design.fatory.impl;

import com.test.design.fatory.base.ILight;

public class RedLight implements ILight {
    public RedLight() {
        lightColor();
    }

    @Override
    public void lightColor() {
        System.out.println(this.getClass().getSimpleName() + "lightColor");
    }
}
