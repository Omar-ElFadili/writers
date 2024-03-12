package com.example.demo.services;


import com.example.demo.dto.BookRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class WriterBookServiceImpl implements WriterBookService {

    private final WriterService writerService;
    private final BookService bookService;
    @Override
    @Transactional
    public void updateWriterAndBook(Long writerId, Long bookID, BookRequestDTO bookDTO) {
        writerService.getWriterById(writerId); // Vérifie si l'écrivain existe
        bookService.getBookById(bookID); // Vérifie si le livre existe

    }
}
