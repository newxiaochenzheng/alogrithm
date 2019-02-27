package com.test.design.fatory;

import com.test.design.fatory.base.IFactory;
import com.test.design.fatory.impl.BenzFactory;

public class AbstractFactoryMain {
    public static void main(String[] args) {
        IFactory factory = new BenzFactory();
        factory.createCar();
        factory.createLight();


    }
}
