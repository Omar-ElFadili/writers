package com.example.demo.services;

import com.example.demo.dto.BookRequestDTO;
import com.example.demo.dto.BookResponseDTO;
import com.example.demo.entities.Book;
import com.example.demo.exceptions.BookNotFoundException;
import com.example.demo.mappers.BookMapper;
import com.example.demo.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookServiceImp implements BookService{
    private final BookRepository bookRepository;

    @Override
    public List<BookResponseDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(BookMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookResponseDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
        return BookMapper.INSTANCE.toResponseDto(book);
    }

    @Override
    public void saveBook(BookRequestDTO bookDTO) {
        Book book = BookMapper.INSTANCE.toEntity(bookDTO);
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Book not found with id: " + id);
        }
        bookRepository.deleteById(id);
    }
    @Override
    public void updateBook(Long id, BookRequestDTO bookDTO) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(bookDTO.getTitle());
            book = bookRepository.save(book);
        } else {
            throw new BookNotFoundException("Book not found with id: " + id);
        }
    }
}
