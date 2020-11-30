package com.example.demo;


import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import com.example.demo.service.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    BookService bookService = new BookServiceImpl();

    @Mock
    BookRepository bookRepository;


    @Test
    public void testGetBooksReturnsAllBook()
    {
        List<Book> list = new ArrayList<>();
        list.add(new Book(1,"ABC","XYZ",10));
        list.add(new Book(2,"CDE","YYZ",20));

        doReturn(list).when(bookRepository).findAll();

        List<Book> res = bookService.getBooks();
        assertEquals(res.size(),list.size());
    }


}
