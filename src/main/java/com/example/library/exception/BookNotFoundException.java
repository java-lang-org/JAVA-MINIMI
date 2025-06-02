package com.example.library.exception;

public class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
        System.out.println("BookNotFoundException occurred: " + message + " at " + System.currentTimeMillis());
    }
} 