package com.test.design.adapter.other;

public class SocketAdapter implements DBInterface {
    public GBInterface gbInterface;

    @Override
    public void powerWithThree() {
        if (gbInterface != null) {
            gbInterface.powerWithTwo();
        }
    }

    public SocketAdapter(GBInterface gbInterface) {
        this.gbInterface = gbInterface;
    }
}
