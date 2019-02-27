package com.test.design.fatory.impl;

import com.test.design.fatory.base.FactoryBase;
import com.test.design.fatory.base.ProductBase;

public class FactoryImpl<T> extends FactoryBase {
    @Override
    public <T extends ProductBase> ProductBase createProduct(Class<T> clazz) {
        try {
            Class clz = Class.forName(clazz.getName());
            return (ProductBase) clz.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
