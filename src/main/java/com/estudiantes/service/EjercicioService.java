package com.estudiantes.service;

import com.estudiantes.dto.EjercicioDto;
import com.estudiantes.entity.Ejercicio;
import com.estudiantes.repository.EjercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EjercicioService {

    public List<EjercicioDto> obtenerEjercicios();

    public EjercicioDto obtenerEjercicio(Long id);

    public EjercicioDto guardar(EjercicioDto ejercicioDto);

    public EjercicioDto editarEjercicio(Long id, EjercicioDto ejercicioDto);

    public boolean eliminarEjercicio(Long id);

}
