package com.estudiantes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PracticaDto {
    private int id;
    private int idUsuario;
    private String entrada;
    private String resultado;
    private String ip;
    private LocalDateTime fecha;
    private boolean estado;
    private int idEjercicio;
    private boolean esFinal;
}
