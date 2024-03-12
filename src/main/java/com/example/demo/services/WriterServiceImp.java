package com.example.demo.services;

import com.example.demo.dto.WriterRequestDTO;
import com.example.demo.dto.WriterResponseDTO;
import com.example.demo.entities.Writer;
import com.example.demo.exceptions.WriterNotFoundException;
import com.example.demo.mappers.WriterMapper;
import com.example.demo.repositories.WriterRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service@AllArgsConstructor
public class WriterServiceImp implements WriterService{

    private final WriterRepository writerRepository;

    @Override
    public List<WriterResponseDTO> getAllWriters() {
        List<Writer> writers = writerRepository.findAll();
        return writers.stream()
                .map(WriterMapper.INSTANCE::toResponseDto)
                .collect(Collectors.toList());
    }
    @Override
    public WriterResponseDTO getWriterById(Long id) {
        Writer writer = writerRepository.findById(id)
                .orElseThrow(() -> new WriterNotFoundException("Writer not found with id: " + id));
        return WriterMapper.INSTANCE.toResponseDto(writer);
    }

    @Override
    public void saveWriter(WriterRequestDTO writerDTO) {
        Writer writer = WriterMapper.INSTANCE.toEntity(writerDTO);
        writerRepository.save(writer);
    }

    @Override
    public void deleteWriter(Long id) {
        if (!writerRepository.existsById(id)) {
            throw new WriterNotFoundException("Writer not found with id: " + id);
        }
        writerRepository.deleteById(id);
    }
    @Override
    public void updateWriter(Long id, WriterRequestDTO writerDTO) {
        Optional<Writer> optionalWriter = writerRepository.findById(id);
        if (optionalWriter.isPresent()) {
            Writer writer = optionalWriter.get();
            writer.setName(writerDTO.getName());
            writerRepository.save(writer);
        } else {
            throw new WriterNotFoundException("Writer not found with id: " +id);
        }
    }
}
