package com.test.design.visitor;

public class CountVisitor implements Visitor {
    private int totalCount = 0;

    public int getTotalCount() {
        return totalCount;
    }

    @Override
    public void visit(Student student) {
        if (student != null) {
            totalCount++;
        }
    }

    @Override
    public void visit(Master master) {

    }
}
