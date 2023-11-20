package com.estudiantes.mapper;

import com.estudiantes.dto.EjercicioDto;
import com.estudiantes.entity.Ejercicio;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EjercicioMapper {

    Ejercicio toEntity(EjercicioDto ejercicioDto);
    EjercicioDto toDto(Ejercicio ejercicio);
    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(EjercicioDto ejercicioDto, @MappingTarget Ejercicio ejercicio);
}
