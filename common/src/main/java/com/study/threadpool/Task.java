package com.study.threadpool;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: LiaoPeng
 * @Date: 2019/5/14
 */
public class Task implements Runnable{
    String taskName;

    public Task(){};
    public Task(String taskName){
        this.taskName = taskName;
    }

    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String name = Thread.currentThread().getName();
        System.out.println(name+" start-->"+taskName+" "+sdf.format(new Date()));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        System.out.println(name+" end-->"+taskName+" "+sdf.format(new Date()));

    }
}
