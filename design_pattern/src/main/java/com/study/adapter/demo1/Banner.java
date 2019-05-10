package com.study.adapter.demo1;

/**
 * @Auther: LiaoPeng
 * @Date: 2019/5/10
 * 广告类定义
 */
public class Banner {
    private String string;
    public Banner(String string){
        this.string = string;
    }

    /**
     * 用"()"号显示广告
     */
    public void showWithParen(){
        System.out.println("("+string+")");
    }

    /**
     * 用"*"显示广告
     */
    public void showWithAster(){
        System.out.println("*"+string+"*");
    }

}
