package com.study.key;

/**
 * @Auther: LiaoPeng
 * @Date: 2019/4/23
 * 测试volatile关键字的作用
 */
public class TestVolatile {
    private static boolean flag=false;
//    private volatile static boolean flag;


    public static void main(String[] args) throws InterruptedException {

        /**
         * 第一，不加volatile下无循环体，线程还是会感知变化，但是时机不定，往往需要很久的时间；
         * 第二，不加volatile下有了循环体后，
         *      一则线程感知的变化的时间会缩短，
         *      二则，根据循环体内的代码，有可能会强制刷新内存，比如打印语句。
         *      而sleep语句会让线程休眠，线程从休眠中苏醒后，在实现上也有可能去主内存刷新一次。
         */
        new Thread(()->{
            while(!flag){
                System.out.println("run1....");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(2000);

        flag = true;

        System.out.println("main.....");

        new TestVolatile().test();

    }

    public void test() throws InterruptedException {
        new Thread(()->{
            while(!flag){
//                System.out.println("run1....");
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }).start();

        Thread.sleep(2000);

        flag = true;

        System.out.println("main.....");
    }

}
