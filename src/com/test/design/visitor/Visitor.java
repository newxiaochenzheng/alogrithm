package com.test.design.visitor;


import com.test.design.clone.Teacher;

public interface Visitor {
    void visit(Student student);
    void visit(Master master);

}
