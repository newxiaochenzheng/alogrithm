package com.test.design.wrapper;

public class BetRoom extends RoomDecorator {
    public BetRoom(Room room) {
        super(room);
    }

    @Override
    public void fitment() {
        super.fitment();
        addBedding();
    }

    private void addBedding() {
        System.out.println("add bedding");
    }
}
