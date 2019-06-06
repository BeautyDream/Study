package com.study.cache.cache;

import java.util.concurrent.TimeUnit;

/**
 * 测试类
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        try {
            Class.forName(CacheManager.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        CacheManager.put("one","第一个数据");
        CacheManager.put("two","第二条数据",50, TimeUnit.SECONDS);
        CacheManager.put("three","第三条数据",3,TimeUnit.MINUTES);

        System.out.println("立刻获取------------------------");
        System.out.println(CacheManager.get("one"));
        System.out.println(CacheManager.get("two"));
        System.out.println(CacheManager.get("three"));

        Thread.sleep(55000);

        System.out.println("55秒后------------------------");
        System.out.println(CacheManager.get("one"));
        System.out.println(CacheManager.get("two"));
        System.out.println(CacheManager.get("three"));

        Thread.sleep(60000-55000);

        System.out.println("1分钟后------------------------");
        System.out.println(CacheManager.get("one"));
        System.out.println(CacheManager.get("two"));
        System.out.println(CacheManager.get("three"));

        Thread.sleep(120000-60000);
        System.out.println("2分钟后------------------------");
        System.out.println(CacheManager.get("one"));
        System.out.println(CacheManager.get("two"));
        System.out.println(CacheManager.get("three"));

        Thread.sleep(180000-120000);
        System.out.println("3分钟时------------------------");
        System.out.println(CacheManager.get("one"));
        System.out.println(CacheManager.get("two"));
        System.out.println(CacheManager.get("three"));

        Thread.sleep(190000-180000);
        System.out.println("3分钟10秒后------------------------");
        System.out.println(CacheManager.get("one"));
        System.out.println(CacheManager.get("two"));
        System.out.println(CacheManager.get("three"));

        System.out.println("缓存的大小: "+CacheManager.getCacheSize());

        System.out.println("main over------------------------");

    }

}
