package com.test.design.resposibility;

public class PlayerA extends Player {
    public PlayerA(Player player) {
        setSuccessor(player);
    }

    @Override
    void handle(int index) {
        if (index == 1) {
            System.out.println("PlayerA  handle");
        } else {
            System.out.println("PlayerA handleNext *****");
            next(index);
        }
    }
}
