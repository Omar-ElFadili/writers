package com.example.demo.mappers;

import com.example.demo.dto.BookRequestDTO;
import com.example.demo.dto.BookResponseDTO;
import com.example.demo.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(target = "id", ignore = true)
    Book toEntity(BookRequestDTO bookRequestDTO);

    BookResponseDTO toDto(Book book);

    @Mapping(target = "id", ignore = true)
    Book toEntity(BookResponseDTO bookRequestDTO);

    BookResponseDTO toResponseDto(Book book);
}