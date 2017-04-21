package com.epam.storage;

import com.epam.bean.Book;
import com.epam.exception.BookCommandException;

import java.util.*;
import java.util.logging.Logger;

/**
 * Created by Mark_Rudak on 4/13/2017.
 */
public class BookStore {

    private static final Logger LOGGER = Logger.getLogger(BookStore.class.getName());

    private static Set<Book> bookSet;


    public BookStore() {
        if (bookSet == null) {
            bookSet = new HashSet<Book>();
            Book bookIdiot = new Book(1, "Idiot", "Dostoevsky", "drama", 1869, 700);
            Book bookFinancier = new Book(2, "Financier", "Theodore Dreiser", "novel", 1912, 750);
            bookSet.add(bookIdiot);
            bookSet.add(bookFinancier);
        }
    }

    public static Set<Book> getAllBooks() {
        return bookSet;
    }


    public static void deleteBook(Book bookDeleted) {
        new BookStore();
        long start = Calendar.getInstance().getTimeInMillis();
        boolean flag = false;
        for (Book book : bookSet) {
            if (book.getId() == bookDeleted.getId()) {
                flag = true;
                bookSet.remove(book);
                break;
            }
        }
        if (flag==true) {
            LOGGER.info("Command deleteBook executed in " + (Calendar.getInstance().getTimeInMillis() - start) + "ms");
        } else {
            throw new BookCommandException("Can't delete book with required id!");
        }
    }

    public static void addBook(Book book) {
        new BookStore();
        bookSet.add(book);
    }

    public static void updateBook(Book book) {
        new BookStore();
        long start = Calendar.getInstance().getTimeInMillis();
        boolean flag = false;
        for (Book booksArray : bookSet) {
            if (booksArray.getId() == book.getId()) {
                booksArray.setAuthor(book.getAuthor());
                booksArray.setBookName(book.getBookName());
                booksArray.setBookType(book.getBookType());
                booksArray.setPageCount(book.getPageCount());
                booksArray.setYear(book.getYear());
                flag = true;
            }
        }
        if (flag) {
            LOGGER.info("Command updateBook executed in " + (Calendar.getInstance().getTimeInMillis() - start) + "ms");
        } else {
            throw new BookCommandException("Can't update book with required id!");
        }
    }

    public boolean bookStoreIsEmpty(){
        return bookSet.isEmpty();
    }

}
