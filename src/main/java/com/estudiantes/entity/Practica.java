package com.estudiantes.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "practica")
public class Practica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
