package com.example.demo.api;


import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import com.example.demo.service.BookServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private static Logger log = LoggerFactory.getLogger(BookController.class);
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/library/books")
    public List<Book> getBooks()
    {
        return bookService.getBooks();
    }

    @PostMapping(value = "/library/books")
    public void createBook(@RequestBody Book book)
    {
        bookService.createBook(book);

    }

    @GetMapping(value = "/library/books/{id}")
    public Book getBookById(@PathVariable long id)
    {
        return bookService.findById(id);
    }

    @Cacheable(value = "books",key = "#title")
    @GetMapping(value = "/library/books/title/{title}")
    public Book getBookByTitle(@PathVariable String title)
    {
        log.info("Getting Book with title {}",title);
        return bookService.getBookByTitle(title);
    }
}
