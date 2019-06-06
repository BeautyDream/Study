package com.study.iterator;

import java.util.ArrayList;

/**
 * @Auther: LiaoPeng
 * @Date: 2019/5/10
 */
public class BookShelf implements Aggregate{
    private ArrayList<Book> books;
    public BookShelf(){
        this.books = new ArrayList<>();
    }
    public Book getBookAt(int index){
        return this.books.get(index);
    }
    public void appendBook(Book book){
        this.books.add(book);
    }
    public int getLength(){
        return books.size();
    }

    /**
     * 获取迭代器
     * @return
     */
    public Iterator iterator(){
        return new BookShelfIterator(this);
    }
}
