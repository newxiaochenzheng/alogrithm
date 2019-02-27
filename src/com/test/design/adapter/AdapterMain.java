package com.test.design.adapter;

public class AdapterMain {
    /**
     * 适配器角色可以继承源角色关联源角色，也是可以把适配器角色对象放到源角色中进行相关，Android中的listView就是用第二种来相关的。
     */
    public static void main(String[] args) {
        Chinese chinese = new Chinese();
        IEnglish adapter = new TranslateAdpater();
        chinese.setAdapter(adapter);
        chinese.speakEnglish("你好");
    }
}
