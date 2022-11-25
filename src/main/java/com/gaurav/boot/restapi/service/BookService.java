package com.gaurav.boot.restapi.service;

import com.gaurav.boot.restapi.entities.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookService {
    private static List<Book> list = new ArrayList<>();
    static {
        list.add(new Book(12452,"Harry Potter","J K Rowling"));
        list.add(new Book(14724,"Mrytunjay","Shivaji Shavant"));
        list.add(new Book(1234,"Importal of Mehula","Amish Tripathi"));
    }

    //get All books
    public List<Book> getAllBook()  {
        return list;
    }

    //get Single book
    public Book getBookById(int bookId) {
        Book book = null;
        book = list.stream().filter(e->e.getBookId()==bookId).findFirst().get();
        return book;
    }
}
