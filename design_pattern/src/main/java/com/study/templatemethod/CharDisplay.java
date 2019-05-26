package com.study.templatemethod;

/**
 * @Auther: LiaoPeng
 * @Date: 2019/5/26
 */
public class CharDisplay extends AbstractDisplay{
    private char ch;        //需要显示的字符

    public CharDisplay(char ch){
        this.ch = ch;
    }

    @Override
    public void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(ch);
    }

    @Override
    public void close() {
        System.out.println(">>");
    }
}
