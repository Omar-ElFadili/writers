package com.example.demo.dto;

import lombok.Data;

@Data
public class BookResponseDTO {
    private Long id;
    private String title;
    private String edition;
    private Long writerId;
}
