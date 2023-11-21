package com.estudiantes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpcionDto {
    private int id;
    private Date fecha;
    private int idEjercicio;
    private int idExamen;
    private int idUsuario;
}
