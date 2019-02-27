package com.test.design.resposibility;

public abstract class Player {
    private Player successor;

    abstract void handle(int index);

    public void setSuccessor(Player successor) {
        this.successor = successor;
    }

    public void next(int index) {
        if (successor != null) {
            successor.handle(index);
        } else {
            System.out.println("game over");
        }
    }
}
