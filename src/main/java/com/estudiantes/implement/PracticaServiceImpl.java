package com.estudiantes.implement;

import com.estudiantes.dto.PracticaDto;
import com.estudiantes.entity.Practica;
import com.estudiantes.mapper.PracticaMapper;
import com.estudiantes.repository.PracticaRepository;
import com.estudiantes.service.PracticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PracticaServiceImpl implements PracticaService {

    @Autowired
    private PracticaRepository practicaRepository;

    @Autowired
    private PracticaMapper practicaMapper;

    @Override
    public List<PracticaDto> obtenerPracticas() {
        List<Practica> practicas = practicaRepository.findAll();
        return practicas.stream()
                .map(practicaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PracticaDto obtenerPractica(Long id) {
        Practica practica = practicaRepository.findById(id).get();
        return practicaMapper.toDto(practica);
    }

    @Override
    public PracticaDto guardarPractica(PracticaDto practicaDto) {

        Practica practica = practicaMapper.toEntity(practicaDto);
        Practica savedPractica = null;
        if (practicaRepository.findById(practica.getId()).isEmpty()) {
            savedPractica = practicaRepository.save(practica);
        }
        return practicaMapper.toDto(savedPractica);

        /* TODO: Puede ser asi tambien
        Practica practica = practicaMapper.toEntity(practicaDto);
        Practica savedPractica = practicaRepository.save(practica);
        return practicaMapper.toDto(savedPractica);
        */

    }

    @Override
    public PracticaDto editarPractica(Long id, PracticaDto practicaDto) {
        Practica practicaFound = practicaRepository.findById(id).get();

        practicaMapper.updateEntity(practicaDto,practicaFound);
        Practica savedPractica = practicaRepository.save(practicaFound);
        return practicaMapper.toDto(savedPractica);

    }

    @Override
    public boolean eliminarPractica(Long id) {

        boolean rta = false;

        if(practicaRepository.findById(id).isPresent()) {
            practicaRepository.deleteById(id);
            rta = true;
        }

        return rta;
    }
}
