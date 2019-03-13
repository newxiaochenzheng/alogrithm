package com.test.test;

public abstract class Drawable {
    private int value;
    public int getValue(){
        return value;
    }
    public void setValue(int value){
        this.value = value;
    }
    public abstract void draw();
}
