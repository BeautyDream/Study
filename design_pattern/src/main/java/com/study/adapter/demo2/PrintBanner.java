package com.study.adapter.demo2;

/**
 * @Auther: LiaoPeng
 * @Date: 2019/5/10
 * 广告打印实现类 （适配器）
 */
public class PrintBanner extends Print {
    private Banner banner;
    public PrintBanner(String string){
        banner = new Banner(string);
    }
    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
