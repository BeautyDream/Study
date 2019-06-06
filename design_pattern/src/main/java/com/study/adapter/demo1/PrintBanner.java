package com.study.adapter.demo1;

/**
 * @Auther: LiaoPeng
 * @Date: 2019/5/10
 * 广告打印实现类 （适配器）
 */
public class PrintBanner extends Banner implements Print {

    public PrintBanner(String string){
        super(string);
    }
    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
