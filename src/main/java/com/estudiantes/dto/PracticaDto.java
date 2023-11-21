package com.estudiantes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PracticaDto {
    private int id;
    private int idUsuario;
    private String entrada;
    private String resultado;
    private String ip;
    private Date fecha;
    private boolean estado;
    private EjercicioDto ejercicio;
    private boolean esFinal;
}
