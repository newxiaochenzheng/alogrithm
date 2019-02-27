package com.test.annotation;


import java.io.File;
import java.lang.reflect.*;

@TestAnnotation(id = 3, msg = "test annotation")
public class AnnotationMain {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        boolean hasAnnotation = AnnotationMain.class.isAnnotationPresent(TestAnnotation.class);
        if (hasAnnotation) {
            TestAnnotation annotation = AnnotationMain.class.getAnnotation(TestAnnotation.class);
            System.out.println(annotation.id());
            System.out.println(annotation.msg());
        }
        System.out.println("====field======");
        Field aField = AnnotationMain.class.getDeclaredField("a");
        System.out.println(Class.forName("[[I").getSimpleName());
        if (aField != null) {
            FieldAnnotation fieldAnnotation = aField.getAnnotation(FieldAnnotation.class);
            if (fieldAnnotation != null) {
                System.out.println(fieldAnnotation.id());
                System.out.println(aField.getName());
                System.out.println(fieldAnnotation.name());
            }
        }
        System.out.println("====method======");
        Method method = AnnotationMain.class.getDeclaredMethod("print", null);
        if (method != null) {
            MethodAnnotation methodAnnotation = method.getAnnotation(MethodAnnotation.class);
            if (methodAnnotation != null) {
                System.out.println(methodAnnotation.name());
            }
        }
        System.out.println("====constructor======");

        Constructor constructor = AnnotationMain.class.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);

        AnnotationMain object = (AnnotationMain) constructor.newInstance(1);
        object.print();
    }

    @FieldAnnotation(name = "aMethod", id = 1)
    private int a;

    @MethodAnnotation(name = "print")
    private void print() {
        System.out.println("print a:" + a);

    }


    private AnnotationMain(int a) {
        this.a = a;
    }
}

