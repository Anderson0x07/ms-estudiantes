package com.estudiantes.controller;

import com.estudiantes.dto.EjercicioDto;
import com.estudiantes.service.EjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ejercicio")
public class EjercicioController {

    @Autowired
    private EjercicioService ejercicioService;

    @GetMapping("/all")
    public ResponseEntity<?> listarEjercicios(){
        return new ResponseEntity<>(ejercicioService.obtenerEjercicios(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerEjercicio(@PathVariable("id") int id){
        EjercicioDto ejercicio = ejercicioService.obtenerEjercicio(id);
        if (ejercicio == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ejercicio, HttpStatus.OK);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarEjercicio(@RequestBody EjercicioDto ejercicioDto) throws Exception {

        EjercicioDto ejercicioSaved = ejercicioService.guardarEjercicio(ejercicioDto);
        return new ResponseEntity<>(ejercicioSaved, HttpStatus.CREATED);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarEjercicio(@PathVariable("id") int id, @RequestBody EjercicioDto ejercicio) throws Exception {
        EjercicioDto ejercicioUpdated =  ejercicioService.editarEjercicio(id, ejercicio);
        if (ejercicioUpdated == null){
            return new ResponseEntity<>("La opcion que desea editar no existe", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ejercicioUpdated, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarEjercicio(@PathVariable("id") int id) throws Exception {
        boolean ejercicioDeleted =  ejercicioService.eliminarEjercicio(id);
        if (ejercicioDeleted){
            return new ResponseEntity<>("Ejercicio eliminado satisfactoriamente", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("El ejercicio no existe", HttpStatus.NOT_FOUND);
    }

}
