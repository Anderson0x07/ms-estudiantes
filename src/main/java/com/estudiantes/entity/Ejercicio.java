package com.estudiantes.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ejercicio")
public class Ejercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
