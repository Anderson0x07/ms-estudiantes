package com.estudiantes.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OpcionDto {
    private Long id;
    private Date fecha;
    private Long idEjercicio;
    private Long idExamen;
    private Long idUsuario;
}
