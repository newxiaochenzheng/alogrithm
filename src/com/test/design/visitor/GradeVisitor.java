package com.test.design.visitor;

public class GradeVisitor implements Visitor {
    @Override
    public void visit(Student student) {
        System.out.println("name:" + student.getName());
    }

    @Override
    public void visit(Master master) {
        System.out.println("name:" + master.getName());

    }
}
