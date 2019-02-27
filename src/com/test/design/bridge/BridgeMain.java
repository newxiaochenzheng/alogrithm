package com.test.design.bridge;

public class BridgeMain {
    public static void main(String[] args) {
        Implementor implementorA = new ImplementorA();
        Implementor implementorB = new ImplementorB();
        Abstraction abstraction = new RefinedAbstraction(implementorA);
        abstraction.operation();

        abstraction.attach(implementorB);
        System.out.println("after attach====");
        abstraction.operation();
    }
}
