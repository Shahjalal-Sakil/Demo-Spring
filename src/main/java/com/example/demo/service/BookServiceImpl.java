package com.example.demo.service;

import com.example.demo.dao.DonorDao;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookRepository bookRepository;




    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findById(long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookRepository.getBookByName(title);
    }

    @Override
    public Book updateBook(long id, Book book) {
        Book book1 = bookRepository.findById(id);

        book1.setName(book.getName());
        book1.setAuthor(book.getAuthor());
        book1.setPrice(book.getPrice());

        bookRepository.save(book1);
        return book1;
    }

    @Override
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }
}
