package com.example.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class WriterRequestDTO {
    @NotEmpty(message = "Le titre ne peut pas être vide")
    @Size(min = 3, max = 255, message = "Le titre doit avoir entre 3 et 255 caractères")
    private String name;

}