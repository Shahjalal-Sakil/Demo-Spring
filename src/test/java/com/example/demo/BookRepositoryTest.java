package com.example.demo;


import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest(excludeAutoConfiguration = {EmbeddedMongoAutoConfiguration.class})
@RunWith(SpringRunner.class)
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    public void testFindAllReturnsAllBooks()
    {
        Book book = new Book(1,"ABC","XYZ",10);

        bookRepository.save(book);

        List<Book> list = bookRepository.findAll();

        assertEquals(list.size(),3);
    }


    @Test
    public void testSaveInsertsBook(){
        Book book = new Book(1,"ABC","XYZ",10);

        bookRepository.save(book);

        Book book2 = bookRepository.findById(book.getId());

        assertEquals(book2,book);
    }

    @Test
    public void testFindByIdReturnsCorrectBook()
    {
        Book book = new Book(1,"ABC","XYZ",10);

        bookRepository.save(book);


        Book book2 = bookRepository.findById(book.getId());

        assertEquals(book2.getName(),book.getName());
    }

    @Test
    public void testGetBookByNameWorks()
    {
        Book book = new Book(1,"ABC","XYZ",10);

        bookRepository.save(book);


        Book book2 = bookRepository.getBookByName(book.getName());

        assertEquals(book2.getName(),book.getName());
        assertEquals(book2.getAuthor(),book.getAuthor());
    }


}
