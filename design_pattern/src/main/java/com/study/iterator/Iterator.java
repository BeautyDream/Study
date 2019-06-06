package com.study.iterator;

/**
 * @Auther: LiaoPeng
 * @Date: 2019/5/10
 * 简单的迭代器接口  作用：将实现和迭代分离开来
 */
public interface Iterator {
    public abstract boolean hasNext();
    public abstract Object next();
}
