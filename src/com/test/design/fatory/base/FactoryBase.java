package com.test.design.fatory.base;

public abstract class FactoryBase {
    public abstract <T extends ProductBase> ProductBase createProduct(Class<T> clazz);

}
