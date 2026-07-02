package com.library.LibraryManagement.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public BookRepository() {
        System.out.println("BookRepository Bean Created");
    }

    public String getBook() {
        return "Harry Potter";
    }
}