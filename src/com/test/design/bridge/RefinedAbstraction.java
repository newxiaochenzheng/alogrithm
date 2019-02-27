package com.test.design.bridge;

public class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    public void operationOther() {
        super.operation();
        System.out.println("operationOther");
    }

    @Override
    public void attach(Implementor implementor) {
        super.attach(implementor);
    }
}
