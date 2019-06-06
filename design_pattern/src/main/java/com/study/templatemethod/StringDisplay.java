package com.study.templatemethod;

/**
 * @Auther: LiaoPeng
 * @Date: 2019/5/26
 */
public class StringDisplay extends AbstractDisplay {
    private String str;
    private int width;
    public StringDisplay(String str){
        this.str = str;
        this.width = str.getBytes().length;
    }

    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|"+str+"|");
    }

    @Override
    public void close() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
