package com.test.design.wrapper;

public abstract class RoomDecorator extends Room {
    private Room room;

    @Override
    public void fitment() {
        room.fitment();
    }

    public RoomDecorator(Room room) {
        this.room = room;
    }
}
