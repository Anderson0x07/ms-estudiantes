package com.estudiantes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EjercicioDto {
    private int id;
    private String descripcion;
    private String explicacion;
    private String solucion;
    private String expSolucion;
    private String solAlternativas;
    private int numPracticas;
    private boolean estado;
    private int idProblema;
}
