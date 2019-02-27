package com.test.design.resposibility;

public class PlayerD extends Player {
    public PlayerD(Player player) {
        setSuccessor(player);
    }

    @Override
    void handle(int index) {
        if (index == 4) {
            System.out.println("PlayerD  handle");
        } else {
            System.out.println("PlayerD handleNext");
            next(index);
        }
    }
}
