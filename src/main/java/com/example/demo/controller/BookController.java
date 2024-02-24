package com.example.demo.controller;


import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {


    private final BookService bookService;

    @GetMapping
    public List<Book> getBooks() {
        return this.bookService.findAllProducts();
    }

    @GetMapping("/search")
    public List<Book> searchBookByQuery(@RequestParam("query") String query) {
        return this.bookService.searchBook(query);
    }

}
