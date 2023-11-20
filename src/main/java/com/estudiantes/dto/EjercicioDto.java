package com.estudiantes.dto;

import lombok.Data;

@Data
public class EjercicioDto {
    private Long id;
    private String descripcion;
    private String explicacion;
    private String solucion;
    private String expSolucion;
    private String solAlternativas;
    private int numPracticas;
    private boolean estado;
    private Long idProblema;
}
