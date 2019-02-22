package com.study.jdk;

import com.study.aspect.Aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: LiaoPeng
 * @Date: 2019/2/21
 * 创建jdk代理类 需要实现InvocationHandler接口
 */
public class JdkProxy implements InvocationHandler {

    private Object target;
    /**
     * 创建目标对象的代理对象
     * @param target 目标类（UserDao的实例对象）
     */
    public Object creatProxy(Object target){
        this.target = target;
        /**
         * 创建代理对象并返回，Proxy静态方法newProxyInstance三个参数的含义
         * 1.传入类加载器
         * 2.目标类所继承的所有接口类
         * 3.当前代理类的实例对象
         */
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }

    /**
     * @param proxy 目标类的代理对象
     * @param method 目标类的方法
     * @param args 目标类的方法参数
     * @return 目标类的返回值
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //创建切面类，即需要进行功能增强的类
        Aspect aspect = new Aspect();
        //目标类方法调用之前调用功能增强
        aspect.checkPermission();
        //调用被代理对象的方法 即：UserDao目标类里的方法
        Object result = method.invoke(target, args);
        //目标类方法调用之后调用功能增强
        aspect.recordLog();
        return result;
    }
}
