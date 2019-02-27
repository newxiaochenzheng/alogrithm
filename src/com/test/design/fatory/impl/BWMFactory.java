package com.test.design.fatory.impl;

import com.test.design.fatory.base.ICar;
import com.test.design.fatory.base.IFactory;
import com.test.design.fatory.base.ILight;

public class BWMFactory implements IFactory {
    @Override
    public ICar createCar() {
        return new BMWCar();
    }

    @Override
    public ILight createLight() {
        return new RedLight();
    }
}
