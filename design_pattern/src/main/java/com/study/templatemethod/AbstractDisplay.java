package com.study.templatemethod;

/**
 * @Auther: LiaoPeng
 * @Date: 2019/5/26
 * 抽象显示类
 */
public abstract class AbstractDisplay {

    public abstract void open();    //交给子类去实现的抽象方法1.open()
    public abstract void print();   //交给子类去实现的抽象方法2.print()
    public abstract void close();   //交给子类去实现的抽象方法3.close()

    public final void display(){    //本抽象类的实现方法display方法，决定流程的方法
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }

}
