package com.test.design.resposibility;

public class PlayerB extends Player {
    public PlayerB(Player player) {
        setSuccessor(player);
    }

    @Override
    void handle(int index) {
        if (index == 2) {
            System.out.println("PlayerB  handle");
        } else {
            System.out.println("PlayerB handleNext ---->");
            next(index);
        }
    }
}
