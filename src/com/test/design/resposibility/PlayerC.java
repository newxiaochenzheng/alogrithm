package com.test.design.resposibility;

public class PlayerC extends Player {
    public PlayerC(Player player) {
        setSuccessor(player);
    }

    @Override
    void handle(int index) {
        if (index == 3) {
            System.out.println("PlayerC handle");
        } else {
            System.out.println("PlayerC handleNext====>");
            next(index);
        }
    }
}
