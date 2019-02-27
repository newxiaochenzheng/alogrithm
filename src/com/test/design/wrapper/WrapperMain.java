package com.test.design.wrapper;

public class WrapperMain {
    public static void main(String[] args) {
        Room newRoom = new RoomImpl();
        Room bedRoom = new BetRoom(newRoom);
        bedRoom.fitment();
        Room kitchenRoom = new KitchenRoom(newRoom);
        kitchenRoom.fitment();
    }
}
