package com.example.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BookRequestDTO {
    @NotEmpty(message = "Le titre ne peut pas être vide")
    @Size(min = 3, max = 255, message = "Le titre doit avoir entre 3 et 255 caractères")
    private String title;
    @Size(max = 255, message = "L'édition doit avoir au maximum 255 caractères")
    private String edition;
    @NotNull(message = "L'ID de l'écrivain ne peut pas être nul")
    private Long writerId;
}
