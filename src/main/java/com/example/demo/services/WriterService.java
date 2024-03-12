package com.example.demo.services;

import com.example.demo.dto.WriterRequestDTO;
import com.example.demo.dto.WriterResponseDTO;

import java.util.List;

public interface WriterService {
    public List<WriterResponseDTO> getAllWriters();

    public WriterResponseDTO getWriterById(Long id);

    public void saveWriter(WriterRequestDTO writer);

    public void deleteWriter(Long id);
    public void updateWriter (Long id, WriterRequestDTO writer);
}
