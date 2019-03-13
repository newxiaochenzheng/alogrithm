package com.test.design.visitor;

public interface Element {
    void accept(Visitor visitor);
}
