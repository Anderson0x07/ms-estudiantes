package com.estudiantes.service;

import com.estudiantes.dto.PracticaDto;
import com.estudiantes.dto.ProblemasResueltosDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PracticaService {

    public List<PracticaDto> obtenerPracticas();

    public PracticaDto obtenerPractica(int id);

    public PracticaDto guardarPractica(PracticaDto practicaDto);

    public PracticaDto editarPractica(int id, PracticaDto practicaDto);

    public boolean eliminarPractica(int id);

    public List<ProblemasResueltosDto> obtenerNumProblemasResueltosByStudents();
}
