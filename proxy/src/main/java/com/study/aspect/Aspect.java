package com.study.aspect;

/**
 * @Auther: LiaoPeng
 * @Date: 2019/2/21
 * 创建切面类（用于增强业务功能的类）
 */
public class Aspect {

    public void checkPermission(){
        System.out.println("检查用户权限...");
    }

    public void recordLog(){
        System.out.println("日志记录...");
    }

}
