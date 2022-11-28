package com.gaurav.boot.restapi.Controllers;

import com.gaurav.boot.restapi.entities.Book;
import com.gaurav.boot.restapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getBooks() {

        List<Book> list = bookService.getAllBook();
        if (list.size()<=0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @RequestMapping(value = "/books/{bookId}", method = RequestMethod.GET)
    public ResponseEntity<Book> getBook(@PathVariable("bookId") int bookId) {

        Book b = bookService.getBookById(bookId);
        if (b==null)    {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(b));
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public Book addBook(@RequestBody Book book) {
        Book b = this.bookService.addBook(book);
        return b;
    }
    //Delete a book through delete request
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId)  {
        try {
            this.bookService.deleteBook(bookId);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e)   {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    //Update Book
    @PutMapping("/books/{bookId}")
    public void updateBook(@PathVariable("bookId") int bookId)  {
        this.bookService.updateBook(bookId);
        //return book;
    }
}