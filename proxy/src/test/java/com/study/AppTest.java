package com.study;

import static org.junit.Assert.assertTrue;

import com.study.cglib.CGLIBProxy;
import com.study.entity.UserDao;
import com.study.entity.UserDao2;
import com.study.entity.UserDaoImpl;
import com.study.jdk.JdkProxy;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest{

    @Test
    public void testJdkProxy(){
        //创建目标对象
        UserDao userDao = new UserDaoImpl();
        //创建代理对象实例并获取增强后的userDao的代理对象
        UserDao proxy = (UserDao) new JdkProxy().creatProxy(userDao);
        // 通过代理对象调用方法
        // proxy对象调用的方法会交给JdkProxy类的invoke()方法处理
        proxy.addUser();
        System.out.println("-------------");
        proxy.delete();
    }

    @Test
    public void testCGLIBProxy(){
        //创建目标对象
        UserDao2 userDao = new UserDao2();
        //创建代理对象实例并获取增强后的userDao的代理对象
        UserDao2 proxy = (UserDao2) new CGLIBProxy().createProxy(userDao);
        // 通过代理对象调用方法
        // proxy对象调用的方法会交给CGLIBProxy类的intercept()方法处理
        proxy.addUser();
        System.out.println("************");
        proxy.delete();
    }

}
