package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {


    private final BookRepository bookRepository;


    public List<Book> findAllProducts() {
        return this.bookRepository.findAll();
    }

    public List<Book> searchBook(String query) {
        return this.bookRepository.findBooksByQuery(query);
    }
}
