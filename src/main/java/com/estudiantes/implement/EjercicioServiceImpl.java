package com.estudiantes.implement;

import com.estudiantes.dto.EjercicioDto;
import com.estudiantes.entity.Ejercicio;
import com.estudiantes.mapper.EjercicioMapper;
import com.estudiantes.repository.EjercicioRepository;
import com.estudiantes.service.EjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EjercicioServiceImpl implements EjercicioService {

    @Autowired
    private EjercicioRepository ejercicioRepository;

    @Autowired
    private EjercicioMapper ejercicioMapper;

    @Override
    public List<EjercicioDto> obtenerEjercicios() {
        List<Ejercicio> ejercicios = ejercicioRepository.findAll();
        return ejercicios.stream()
                .map(ejercicioMapper::toDto)
                .collect(Collectors.toList());

    }

    @Override
    public EjercicioDto obtenerEjercicio(int id) {
        //Ejercicio ejercicio = ejercicioRepository.findById(id).get();
        //return ejercicioMapper.toDto(ejercicio);
        Optional<Ejercicio> optionalEjercicio = ejercicioRepository.findById(id);

        if (optionalEjercicio.isPresent()) {
            Ejercicio ejercicio = optionalEjercicio.get();
            return ejercicioMapper.toDto(ejercicio);
        }
        else return null;

    }

    @Override
    public EjercicioDto guardarEjercicio(EjercicioDto ejercicioDto) {
        Ejercicio ejercicio = ejercicioMapper.toEntity(ejercicioDto);
        Ejercicio savedEjercicio = null;
        if (ejercicioRepository.findById(ejercicio.getId()).isEmpty()) {
            savedEjercicio = ejercicioRepository.save(ejercicio);
        } else {
            throw new RuntimeException("El ejercicio ya existe");
        }
        return ejercicioMapper.toDto(savedEjercicio);

        /* TODO: Puede ser asi tambien
        Ejercicio ejercicio = ejercicioMapper.toEntity(ejercicioDto);
        Ejercicio savedEjercicio = ejercicioRepository.save(ejercicio);
        return ejercicioMapper.toDto(savedEjercicio);
        */
    }

    @Override
    public EjercicioDto editarEjercicio(int id, EjercicioDto ejercicioDto) {
        Ejercicio ejercicioFound = ejercicioRepository.findById(id).get();
        ejercicioMapper.updateEntity(ejercicioDto, ejercicioFound);
        Ejercicio savedEjercicio = ejercicioRepository.save(ejercicioFound);
        return ejercicioMapper.toDto(savedEjercicio);
    }

    @Override
    public boolean eliminarEjercicio(int id) {
        if (ejercicioRepository.findById(id).isEmpty()){
            return false;
        }
        ejercicioRepository.deleteById(id);
        return true;
    }
}
