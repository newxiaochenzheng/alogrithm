package com.test.design.adapter;

public class Chinese {
    IEnglish adapter;

    public void setAdapter(IEnglish adapter) {
        this.adapter = adapter;
    }

    public void speakEnglish(String msg) {
        adapter.speakEnglish(msg);
    }
}
