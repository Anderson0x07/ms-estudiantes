package com.estudiantes.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "ejercicio")
public class Ejercicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descripcion;

    private String explicacion;

    private String solucion;

    private String expSolucion;

    private String solAlternativas;

    private int numPracticas;

    private boolean estado;

    private int idProblema;

    @JsonIgnoreProperties("ejercicio")
    @OneToMany(mappedBy = "ejercicio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Opcion> opciones;
}
