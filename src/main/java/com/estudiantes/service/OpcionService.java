package com.estudiantes.service;

import com.estudiantes.dto.OpcionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OpcionService {

    public List<OpcionDto> obtenerOpciones();

    public OpcionDto obtenerOpcion(int id);

    public OpcionDto guardarOpcion(OpcionDto opcionDto);

    public OpcionDto editarOpcion(int id, OpcionDto opcionDto);

    public boolean eliminarOpcion(int id);
}
