package com.test.design.visitor;

public class Master implements Element {
    private String name;
    private int grade;

    public Master(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
