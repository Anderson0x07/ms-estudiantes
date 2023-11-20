package com.estudiantes.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PracticaDto {
    private Long id;
    private Long idUsuario;
    private String entrada;
    private String resultado;
    private String ip;
    private LocalDateTime fecha;
    private boolean estado;
    private Long idEjercicio;
    private boolean esFinal;
}
