package com.test.design.adapter;

public class TranslateAdpater implements IEnglish {
    @Override
    public void speakEnglish(String msg) {
        System.out.println(msg + " to english is:" + "how are you!");
    }
}
