package com.estudiantes.service;

import com.estudiantes.dto.EjercicioDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EjercicioService {

    public List<EjercicioDto> obtenerEjercicios();

    public EjercicioDto obtenerEjercicio(int id);

    public EjercicioDto guardarEjercicio(EjercicioDto ejercicioDto);

    public EjercicioDto editarEjercicio(int id, EjercicioDto ejercicioDto);

    public boolean eliminarEjercicio(int id);

}
