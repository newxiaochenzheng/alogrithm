package com.test;

public abstract class Factory {
    public abstract <T extends Product> Product createProduct(Class<T> clazz);
}
