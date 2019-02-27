package com.test.design.wrapper;

public class KitchenRoom extends RoomDecorator {
    public KitchenRoom(Room room) {
        super(room);
    }

    @Override
    public void fitment() {
        super.fitment();
        addKitchen();
    }

    private void addKitchen() {
        System.out.println("add addKitchen");
    }
}
