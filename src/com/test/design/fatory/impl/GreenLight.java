package com.test.design.fatory.impl;

import com.test.design.fatory.base.ILight;

public class GreenLight implements ILight {
    public GreenLight() {
        lightColor();
    }

    @Override
    public void lightColor() {
        System.out.println(this.getClass().getSimpleName() + " lightColor");
    }
}
