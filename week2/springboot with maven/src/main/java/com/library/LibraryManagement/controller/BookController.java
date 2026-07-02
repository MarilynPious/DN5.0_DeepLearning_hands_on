package com.library.LibraryManagement.controller;

import com.library.LibraryManagement.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService service) {
        this.bookService = service;
        System.out.println("BookController Bean Created");
    }

    @GetMapping("/book")
    public String getBook() {
        return bookService.getBook();
    }
}