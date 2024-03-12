package com.example.demo.exceptions;

public class WriterNotFoundException extends RuntimeException {
    public WriterNotFoundException(String id) {
        super("Writer not found with id: " + id);
    }
}

