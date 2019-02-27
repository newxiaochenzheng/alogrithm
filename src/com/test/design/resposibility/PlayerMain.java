package com.test.design.resposibility;

public class PlayerMain {
    public static void main(String[] args) {
        Player playerD = new PlayerD(null);
        Player playerC = new PlayerC(playerD);
        Player playerB = new PlayerB(playerC);
        Player playerA = new PlayerA(playerB);
        playerA.handle(5);
    }
}
