package com.study.iterator;

/**
 * @Auther: LiaoPeng
 * @Date: 2019/5/10
 */
public class BookShelfIterator implements Iterator {
    private BookShelf bookShelf;
    private int index;
    BookShelfIterator(BookShelf bookShelf){
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if(index<bookShelf.getLength()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Object next() {
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}
