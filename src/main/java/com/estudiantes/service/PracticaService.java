package com.estudiantes.service;

import com.estudiantes.dto.PracticaDto;
import com.estudiantes.entity.Practica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PracticaService {

    public List<PracticaDto> obtenerPracticas();

    public PracticaDto obtenerPractica(Long id);

    public PracticaDto guardarPractica(PracticaDto practicaDto);

    public PracticaDto editarPractica(Long id, PracticaDto practicaDto);

    public boolean eliminarPractica(Long id);
}
