package com.test.design.fatory.base;

/**
 * https://www.jianshu.com/p/e13b1151192f
 * 工厂方法模式：一个抽象工厂类可和一个抽象产品类，每个具体工厂类只能生产一个具体产品类
 * 抽象工厂模式是：一个抽象工厂类和多个抽象产品类，每个具体工厂类可以生产多种具体产品类
 */
public abstract class FactoryBase {
    public abstract <T extends ProductBase> ProductBase createProduct(Class<T> clazz);

}
