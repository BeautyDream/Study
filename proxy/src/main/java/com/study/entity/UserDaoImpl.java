package com.study.entity;

/**
 * @Auther: LiaoPeng
 * @Date: 2019/2/21
 */

/**
 * 接口实现类
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("添加用户");
    }
    @Override
    public void delete() {
        System.out.println("删除用户");
    }
    public void edit(){
        System.out.println("编辑用户");
    }
}
