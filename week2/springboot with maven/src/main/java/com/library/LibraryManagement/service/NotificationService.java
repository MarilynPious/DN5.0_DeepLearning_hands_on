package com.library.LibraryManagement.service;

import com.library.LibraryManagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private BookRepository bookRepository;

    public NotificationService() {
    }

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookRepository injected using Setter Injection");
    }

    public String sendNotification() {
        return "Notification sent for " + bookRepository.getBook();
    }
}