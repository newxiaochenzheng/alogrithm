package com.test.design.fatory.impl;

import com.test.design.fatory.base.ILight;
import com.test.design.fatory.base.ICar;
import com.test.design.fatory.base.IFactory;

public class BenzFactory implements IFactory {
    @Override
    public ICar createCar() {
        return new BenzCar();
    }

    @Override
    public ILight createLight() {
        return new GreenLight();
    }
}
