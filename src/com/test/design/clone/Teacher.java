package com.test.design.clone;

public class Teacher implements Cloneable {
    public Teacher() {
        System.out.println("teacher constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private int age;

    @Override
    protected Teacher clone() throws CloneNotSupportedException {
        return (Teacher) super.clone();
    }

    @Override
    public String toString() {
        return "name=" + getName() + ",age=" + getAge();
    }
}
