package com.test.design.clone;

import java.util.ArrayList;
import java.util.List;

public class CloneMain {
    public static void main(String[] args) {
        Intent intent = new Intent();
        intent.setAction("action_view").setPackage("com.test.pkg").setType("1").setTeacher("lisa", 23);
        Intent o = intent.clone().setAction("action_other").setTeacher("lisa1", 23);
        System.out.println(o);
        System.out.println(intent);

    }

}
