package com.study.cglib;

import com.study.aspect.Aspect;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Auther: LiaoPeng
 * @Date: 2019/2/21
 */
//继承MethodInterceptor接口并实现intercept()方法
public class CGLIBProxy implements MethodInterceptor {

    public Object createProxy(Object target){
        //创建一个动态类的对象 Enhancer是CGLIB的核心类通过它来创建代理对象
        Enhancer enhancer = new Enhancer();
        //设置父类，即设置需要进行功能增强的类
        enhancer.setSuperclass(target.getClass());
        //设置回调方法
        enhancer.setCallback(this);
        //创建代理类并返回
        return enhancer.create();
    }

    /**
     * @param proxy 目标类的代理对象
     * @param method 目标类的方法
     * @param args 目标类方法所需要的参数
     * @param methodProxy 目标类方法的代理方法对象
     * @return 目标类的返回值
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        //创建切面类，即需要进行功能增强的类
        Aspect aspect = new Aspect();
        aspect.checkPermission();
        //调用被代理的方法
        Object result = methodProxy.invokeSuper(proxy,args);
        aspect.recordLog();
        return result;
    }
}
