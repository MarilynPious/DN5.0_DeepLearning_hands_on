package com.library.LibraryManagement.service;

import com.library.LibraryManagement.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository repository) {
        this.bookRepository = repository;
        System.out.println("BookService Bean Created");
    }
    public String getBook() {
        return bookRepository.getBook();
    }
}