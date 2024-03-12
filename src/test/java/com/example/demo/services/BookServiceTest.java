package com.example.demo.services;

import com.example.demo.dto.BookResponseDTO;
import com.example.demo.entities.Book;
import com.example.demo.entities.Writer;
import com.example.demo.repositories.BookRepository;
import com.example.demo.services.BookServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BookServiceTest {
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImp bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testGetAllBooks() {
        // Given
        List<Book> books = new ArrayList<>();
        // populate books list
        // Stubbing repository method
        when(bookRepository.findAll()).thenReturn(books);
        // When
        List<BookResponseDTO> responseDTOList = bookService.getAllBooks();
        // Then
        assertEquals(books.size(), responseDTOList.size());
        // add more assertions based on your logic
    }

    @Test
    public void testGetBookById() {
        // Given
        Long id = 1L;
        Book book = new Book();
        book.setId(id);
        // Stubbing repository method
        when(bookRepository.findById(id)).thenReturn(Optional.of(book));
        // When
        BookResponseDTO responseDTO = bookService.getBookById(id);
        // Then
        assertNotNull(responseDTO);
        assertEquals(id, responseDTO.getId());
        // add more assertions based on your logic
    }
}
