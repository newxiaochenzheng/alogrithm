package com.test.design.fatory;

import com.test.design.fatory.base.FactoryBase;
import com.test.design.fatory.base.ICar;
import com.test.design.fatory.base.IFactory;
import com.test.design.fatory.base.ProductBase;
import com.test.design.fatory.impl.BMWCar;
import com.test.design.fatory.impl.BenzFactory;
import com.test.design.fatory.impl.FactoryImpl;
import com.test.design.fatory.impl.ProductBaseA;

public class AbstractFactoryMain {
    public static void main(String[] args) {
        IFactory factory = new BenzFactory();
        factory.createCar();
        factory.createLight();


        FactoryBase factoryBase = new FactoryImpl<ProductBaseA>();
        ProductBaseA product = (ProductBaseA) factoryBase.createProduct(ProductBaseA.class);

        product.doSth();
    }
}
