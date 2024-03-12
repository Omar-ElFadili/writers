package com.example.demo.mappers;

import com.example.demo.dto.WriterRequestDTO;
import com.example.demo.dto.WriterResponseDTO;
import com.example.demo.entities.Writer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WriterMapper {
    WriterMapper INSTANCE = Mappers.getMapper(WriterMapper.class);

    @Mapping(target = "id", ignore = true)
    Writer toEntity(WriterRequestDTO writerRequestDTO);

    WriterResponseDTO toDto(Writer writer);

    WriterResponseDTO toResponseDto(Writer writer);
}
