package com.study.adapter.demo1;

/**
 * @Auther: LiaoPeng
 * @Date: 2019/5/10
 * 类适配器模式（使用继承的适配器）
 */
public class Main {

    public static void main(String[] args) {
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }

}
