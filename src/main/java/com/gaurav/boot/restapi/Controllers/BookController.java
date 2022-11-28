package com.gaurav.boot.restapi.Controllers;

import com.gaurav.boot.restapi.entities.Book;
import com.gaurav.boot.restapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBooks() {
        return this.bookService.getAllBook();
    }

    @RequestMapping(value = "/books/{bookId}", method = RequestMethod.GET)
    public Book getBook(@PathVariable("bookId") int bookId) {
        return this.bookService.getBookById(bookId);
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public Book addBook(@RequestBody Book book) {
        Book b = this.bookService.addBook(book);
        return b;
    }
    //Delete a book through delete request
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId)  {
        this.bookService.deleteBook(bookId);

    }

    //Update Book
    @PutMapping("/books/{bookId}")
    public Book updateBook(@PathVariable("bookId") int bookId)  {
        Book book =this.bookService.updateBook(bookId);
        return book;
    }
}