package com.estudiantes.repository;

import com.estudiantes.entity.Practica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticaRepository extends JpaRepository<Practica, Integer> {
}
