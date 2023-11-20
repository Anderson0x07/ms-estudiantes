package com.estudiantes.service;

import com.estudiantes.dto.OpcionDto;
import com.estudiantes.entity.Opcion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OpcionService {

    public List<OpcionDto> obtenerOpciones();

    public OpcionDto obtenerOpcion(Long id);

    public OpcionDto guardarOpcion(OpcionDto opcionDto);

    public OpcionDto editarOpcion(Long id, OpcionDto opcionDto);

    public boolean eliminarOpcion(Long id);
}
