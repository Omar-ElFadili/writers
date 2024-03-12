package com.example.demo.services;

import com.example.demo.dto.WriterResponseDTO;
import com.example.demo.entities.Writer;
import com.example.demo.repositories.WriterRepository;
import com.example.demo.services.WriterServiceImp;
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

public class WriterServiceTest {
    @Mock
    private WriterRepository writerRepository;

    @InjectMocks
    private WriterServiceImp writerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testGetAllWriters() {
        // Given
        List<Writer> writers = new ArrayList<>();
        // populate writers list

        // Stubbing repository method
        when(writerRepository.findAll()).thenReturn(writers);

        // When
        List<WriterResponseDTO> responseDTOList = writerService.getAllWriters();

        // Then
        assertEquals(writers.size(), responseDTOList.size());
        // add more assertions based on your logic
    }

    @Test
    public void testGetWriterById() {
        // Given
        Long id = 1L;
        Writer writer = new Writer();
        writer.setId(id);
        // Stubbing repository method
        when(writerRepository.findById(id)).thenReturn(Optional.of(writer));

        // When
        WriterResponseDTO responseDTO = writerService.getWriterById(id);

        // Then
        assertNotNull(responseDTO);
        assertEquals(id, responseDTO.getId());
        // add more assertions based on your logic
    }
}
