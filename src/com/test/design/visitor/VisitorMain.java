package com.test.design.visitor;

import java.util.ArrayList;
import java.util.List;

public class VisitorMain {
    public static void main(String[] args) {
        List<Element> list = new ArrayList<>();
        Master master = new Master("master1",12);
        list.add(master);
        list.add(new Student("student1",8));
        list.add(new Student("student2",8));

        Visitor gradeVisitor = new GradeVisitor();
        CountVisitor countVisitor = new CountVisitor();
        for (Element e : list) {
            e.accept(gradeVisitor);
            e.accept(countVisitor);
        }
        System.out.println(countVisitor.getTotalCount());


    }
}
