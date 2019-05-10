package com.study.iterator;

/**
 * @Auther: LiaoPeng
 * @Date: 2019/5/10
 */
public class BookShelf implements Aggregate{
    private Book[] books;
    private int last = 0;
    public BookShelf(int maxsize){
        this.books = new Book[maxsize];
    }
    public Book getBookAt(int index){
        return this.books[index];
    }
    public void appendBook(Book book){
        this.books[last] = book;
        last++;
    }
    public int getLength(){
        return last;
    }

    /**
     * 获取迭代器
     * @return
     */
    public Iterator iterator(){
        return new BookShelfIterator(this);
    }
}
