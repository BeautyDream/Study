package com.study.adapter.demo2;

import com.study.adapter.demo1.Print;
import com.study.adapter.demo1.PrintBanner;

/**
 * @Auther: LiaoPeng
 * @Date: 2019/5/10
 * 对象适配器模式（使用委托的适配器）
 */
public class Main {
    public static void main(String[] args) {
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }
}
