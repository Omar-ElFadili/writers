package com.example.demo.services;

import com.example.demo.dto.BookRequestDTO;
import org.springframework.transaction.annotation.Transactional;

public interface WriterBookService {

    @Transactional
    void updateWriterAndBook(Long writerId, Long bookId, BookRequestDTO bookDTO);

}
