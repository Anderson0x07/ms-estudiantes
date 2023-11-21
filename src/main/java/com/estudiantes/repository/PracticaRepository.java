package com.estudiantes.repository;

import com.estudiantes.dto.ProblemasResueltosDto;
import com.estudiantes.dto.ProblemasResueltosProjection;
import com.estudiantes.entity.Practica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PracticaRepository extends JpaRepository<Practica, Integer> {

    @Query("SELECT p.idUsuario as idUsuario, COUNT(*) as cantidadResueltos " +
            "FROM Practica p " +
            "WHERE p.resultado = 'Consulta correcta' " +
            "GROUP BY p.idUsuario " +
            "ORDER BY cantidadResueltos DESC ")
    List<ProblemasResueltosProjection> findProblemasResueltos();
}
