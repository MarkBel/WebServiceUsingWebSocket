package com.epam.storage;

import com.epam.bean.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark_Rudak on 4/13/2017.
 */
public class BookStore {

    static List<Book> bookArrayList;




    public BookStore() {
        if (bookArrayList == null) {
            bookArrayList = new ArrayList<Book>();
            Book bookIdiot = new Book(1, "Idiot", "Dostoevsky", "drama", 1869, 700);
            Book bookFinancier = new Book(2, "Financier", "Theodore Dreiser", "novel", 1912, 750);
            bookArrayList.add(bookIdiot);
            bookArrayList.add(bookFinancier);
        }
    }

    public static List<Book> getAllBooks() {
        return bookArrayList;
    }


    public static void deleteBook(Book bookDeleted) {

        boolean flag = false;
            for (Book book : bookArrayList) {
                if (book.getId() == bookDeleted.getId()) {
                    bookArrayList.remove(book);
                    System.out.println("Delete book!");
                    flag = true;
                    break;
                }

            }
            if (flag == false) {
                System.out.println("Not matching!");
            }
            else {
                System.out.println("Exit!");
            }
    }

    public static void addBook(Book book) {
        bookArrayList.add(book);
    }

    public static void updateBook(Book book) {
            for (Book booksArray : bookArrayList) {
                if (booksArray.getId() == book.getId()) {
                    booksArray.setAuthor(book.getAuthor());
                    booksArray.setBookName(book.getBookName());
                    booksArray.setBookType(book.getBookType());
                    booksArray.setPageCount(book.getPageCount());
                    booksArray.setYear(book.getYear());
                }
            }
    }
}
