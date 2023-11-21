package com.estudiantes.mapper;

import com.estudiantes.dto.PracticaDto;
import com.estudiantes.entity.Practica;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PracticaMapper {

    Practica toEntity(PracticaDto practicaDto);
    PracticaDto toDto(Practica practica);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(PracticaDto practicaDto, @MappingTarget Practica practica);
}