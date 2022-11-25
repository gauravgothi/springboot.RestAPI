package com.gaurav.boot.restapi.Controllers;

import com.gaurav.boot.restapi.entities.Book;
import com.gaurav.boot.restapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBooks()    {
        return this.bookService.getAllBook();
    }

    @RequestMapping(value = "/books/{bookId}", method = RequestMethod.GET)
    public Book getBook(@PathVariable("bookId") int bookId)    {
        return this.bookService.getBookById(bookId);
    }
}
