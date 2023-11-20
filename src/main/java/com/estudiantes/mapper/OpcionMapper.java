package com.estudiantes.mapper;

import com.estudiantes.dto.OpcionDto;
import com.estudiantes.entity.Opcion;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface OpcionMapper {

    Opcion toEntity(OpcionDto opcionDto);
    OpcionDto toDto(Opcion opcion);
    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(OpcionDto opcionDto, @MappingTarget Opcion opcion);
}
