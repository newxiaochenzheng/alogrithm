package com.test;

public class Main {
    public static void main(String[] args) {
        Factory factory = new ConcreteFactory();
        Product productA = factory.createProduct(ProductA.class);
        productA.func();
        Product productB = factory.createProduct(ProductB.class);
        productB.func();
    }
}
