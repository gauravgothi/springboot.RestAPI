package com.gaurav.boot.restapi.service;

import com.gaurav.boot.restapi.dao.BookRepositry;
import com.gaurav.boot.restapi.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookService {

        @Autowired
        private BookRepositry bookRepositry;
//    private static List<Book> list = new ArrayList<>();
//    static {
//        list.add(new Book(12452,"Harry Potter","J K Rowling"));
//        list.add(new Book(14724,"Mrytunjay","Shivaji Shavant"));
//        list.add(new Book(1234,"Importal of Mehula","Amish Tripathi"));
//    }

    //get All books
    public List<Book> getAllBook()  {
        return (List<Book>) this.bookRepositry.findAll();
    }

    //get Single book
    public Book getBookById(int bookId) {
        Book book = null;
        try {
            //book = list.stream().filter(e->e.getBookId()==bookId).findFirst().get();
            book = (Book) this.bookRepositry.findByBookId(bookId);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return book;
    }

    // to add book
    public Book addBook(Book b) {
        return (Book) this.bookRepositry.save(b);
    }

    public void deleteBook(int bookId) {
        //Book b = getBookById(bookId);
       // System.out.println(b + " is deleted");
        //  list.remove(getBookById(bookId));
        this.bookRepositry.deleteById(bookId);

    }

    //Update Book Service
    public void updateBook(String bookAuthor,int bookId) {
        Book b = getBookById(bookId);
        b.setBookAuthor(bookAuthor);
//        return getBookById(bookId);
        this.bookRepositry.save(b);
    }
}
