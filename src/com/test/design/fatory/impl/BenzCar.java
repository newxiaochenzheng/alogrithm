package com.test.design.fatory.impl;

import com.test.design.fatory.base.ICar;

public class BenzCar implements ICar {
    public BenzCar(){
        carColor();
        carPrice();
        carSpeed();
    }
    @Override
    public void carColor() {
        System.out.println(this.getClass().getSimpleName() + " carColor");
    }

    @Override
    public void carSpeed() {
        System.out.println(this.getClass().getSimpleName() + " carSpeed");
    }

    @Override
    public void carPrice() {
        System.out.println(this.getClass().getSimpleName() + " carPrice");
    }
}
