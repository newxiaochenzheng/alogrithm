package com.test.design.adapter.other;

public class AdapterMain {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        DBInterface dbSocket = new DBSocket();
        hotel.setSocketAdapter(dbSocket);
        hotel.charge();

        System.out.println("after adapter");
        GBInterface gbSocket = new GBSocket();
        SocketAdapter socketAdapter = new SocketAdapter(gbSocket);
        hotel.setSocketAdapter(socketAdapter);
        hotel.charge();
    }
}
