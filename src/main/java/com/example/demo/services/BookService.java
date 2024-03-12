package com.example.demo.services;

import com.example.demo.dto.BookRequestDTO;
import com.example.demo.dto.BookResponseDTO;

import java.util.List;

public interface BookService {

    public List<BookResponseDTO> getAllBooks();

    public BookResponseDTO getBookById(Long id);

    public void saveBook(BookRequestDTO book);

    public void deleteBook(Long id);

    void updateBook(Long id, BookRequestDTO bookDTO);
}
