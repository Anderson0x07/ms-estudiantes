package com.estudiantes.implement;

import com.estudiantes.dto.EjercicioDto;
import com.estudiantes.dto.OpcionDto;
import com.estudiantes.entity.Ejercicio;
import com.estudiantes.entity.Opcion;
import com.estudiantes.mapper.EjercicioMapper;
import com.estudiantes.mapper.OpcionMapper;
import com.estudiantes.repository.EjercicioRepository;
import com.estudiantes.repository.OpcionRepository;
import com.estudiantes.service.EjercicioService;
import com.estudiantes.service.OpcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OpcionServiceImpl implements OpcionService {

    @Autowired
    private OpcionRepository opcionRepository;

    @Autowired
    private EjercicioService ejercicioService;

    @Autowired
    private OpcionMapper opcionMapper;

    @Autowired
    private EjercicioMapper ejercicioMapper;

    @Override
    public List<OpcionDto> obtenerOpciones() {
        List<Opcion> opciones = opcionRepository.findAll();
        return opciones.stream()
                .map(opcionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OpcionDto obtenerOpcion(int id) {
        Opcion opcion = opcionRepository.findById(id).get();
        return opcionMapper.toDto(opcion);
    }

    @Override
    public OpcionDto guardarOpcion(OpcionDto opcionDto) {
        Opcion opcion = opcionMapper.toEntity(opcionDto);

        //EjercicioDto ejercicioDto = ejercicioService.obtenerEjercicio(opcionDto.getIdEjercicio());
        //Ejercicio ejercicio = ejercicioMapper.toEntity(ejercicioDto);
        //System.out.println("ejercicio:" + ejercicio);
        //opcion.setEjercicio(ejercicio);
        //System.out.println("opcion"+ opcion);

        Opcion savedOpcion = opcionRepository.save(opcion);
        return opcionMapper.toDto(savedOpcion);

    }

    @Override
    public OpcionDto editarOpcion(int id, OpcionDto opcionDto) {
        Opcion opcionFound = opcionRepository.findById(id).get();

        opcionMapper.updateEntity(opcionDto,opcionFound);
        Opcion savedOpcion = opcionRepository.save(opcionFound);
        return opcionMapper.toDto(savedOpcion);

    }

    @Override
    public boolean eliminarOpcion(int id) {
        if (opcionRepository.findById(id).isEmpty()){
            return false;
        }
        opcionRepository.deleteById(id);
        return true;
    }
}
