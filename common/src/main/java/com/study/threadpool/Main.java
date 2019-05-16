package com.study.threadpool;

/**
 * @Auther: LiaoPeng
 * @Date: 2019/5/14
 */
public class Main {
    public static void main(String[] args) {
        /** 创建一个有5个核心线程和100个线程池等待队列的线程池对象*/
        MyThreadPool myThreadPool = new MyThreadPool(5,100);
        /** 加入8个任务 */
        for (int i = 0; i < 8; i++) {
            myThreadPool.execute(new Task("TaskName"+(i+1)));
        }

        //...
        System.out.println(myThreadPool.toString());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(myThreadPool.toString());
//        myThreadPool.destroy();
    }
}
