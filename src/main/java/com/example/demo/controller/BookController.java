package com.example.demo.controller;


import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {


    private final BookService bookService;

    @GetMapping
    public List<Book> getBooks() {
        return this.bookService.findAllBooks();
    }


    @GetMapping("/search")
    public List<Book> searchBookByQuery(@RequestParam("query") String query) {
        return this.bookService.searchBook(query);
    }


}
