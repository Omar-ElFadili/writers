package com.example.demo.controllers;

import com.example.demo.dto.WriterRequestDTO;
import com.example.demo.dto.WriterResponseDTO;
import com.example.demo.services.WriterBookService;
import com.example.demo.services.WriterService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController@AllArgsConstructor
@RequestMapping("/api/writers")
public class WriterController {

    private final WriterService writerService;
    private final WriterBookService writerBookService;


    @GetMapping
    public ResponseEntity<List<WriterResponseDTO>> getAllWriters() {
        List<WriterResponseDTO> writers = writerService.getAllWriters();
        return ResponseEntity.ok(writers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WriterResponseDTO> findWriterById(@PathVariable Long id) {
        WriterResponseDTO writer = writerService.getWriterById(id);
        if (writer != null) {
            return ResponseEntity.ok(writer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createWriter(@RequestBody @Valid WriterRequestDTO writerDTO) {
        writerService.saveWriter(writerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("the writer hes been created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> alterWriter(@PathVariable Long id, @RequestBody @Valid WriterRequestDTO writerDTO) {
        writerService.updateWriter(id, writerDTO);
        return ResponseEntity.ok("this writer has updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWriter(@PathVariable Long id) {
        writerService.deleteWriter(id);
        return ResponseEntity.ok("this writer has been deleted");
    }
}
