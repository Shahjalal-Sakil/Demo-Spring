package com.example.demo.service;

import com.example.demo.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooks();
    void createBook(Book book);
    Book findById(long id);
    Book getBookByTitle(String title);
    Book updateBook(long id, Book book);
    void deleteBook(long id);
}
