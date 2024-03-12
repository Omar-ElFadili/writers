package com.example.demo.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String id) {
        super("Writer not found with id: " + id);
    }
}
