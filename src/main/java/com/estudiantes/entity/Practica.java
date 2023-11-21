package com.estudiantes.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "practica")
public class Practica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Long idUsuario;

    private String entrada;

    private String resultado;

    private String ip;

    private LocalDateTime fecha;

    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "ejercicio")
    private Ejercicio ejercicio;

    private boolean esFinal;
}
