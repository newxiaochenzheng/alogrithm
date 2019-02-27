package com.test.design.bridge;

public class ImplementorA implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("ImplementorA");
    }
}
