package com.test.design.adapter.other;

public class Hotel {
    DBInterface dbInterface;

    public void setSocketAdapter(DBInterface dbInterface) {
        this.dbInterface = dbInterface;
    }

    public void charge() {
        if (this.dbInterface != null) {
            dbInterface.powerWithThree();
        }
    }
}
