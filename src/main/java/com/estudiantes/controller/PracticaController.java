package com.estudiantes.controller;

import com.estudiantes.dto.PracticaDto;
import com.estudiantes.service.PracticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/practica")
public class PracticaController {

    @Autowired
    private PracticaService practicaService;

    @GetMapping("/all")
    public ResponseEntity<?> listarPracticas(){
        return new ResponseEntity<>(practicaService.obtenerPracticas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPractica(@PathVariable("id") int id){
        PracticaDto practica = practicaService.obtenerPractica(id);
        if (practica == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(practica, HttpStatus.OK);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarPractica(@RequestBody PracticaDto practicaDto) throws Exception {

        PracticaDto practicaSaved = practicaService.guardarPractica(practicaDto);
        return new ResponseEntity<>(practicaSaved, HttpStatus.CREATED);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarPractica(@PathVariable("id") int id, @RequestBody PracticaDto practica) throws Exception {
        PracticaDto practicaUpdated =  practicaService.editarPractica(id, practica);
        if (practicaUpdated == null){
            return new ResponseEntity<>("La opcion que desea editar no existe", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(practicaUpdated, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPractica(@PathVariable("id") int id) throws Exception {
        boolean practicaDeleted =  practicaService.eliminarPractica(id);
        if (practicaDeleted){
            return new ResponseEntity<>("Practica eliminada satisfactoriamente", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("La practica no existe", HttpStatus.NOT_FOUND);
    }

    @GetMapping("resueltos-ordenados")
    public ResponseEntity<?> getNumProblemasResueltosByStudents(){
        return new ResponseEntity<>(practicaService.obtenerNumProblemasResueltosByStudents(), HttpStatus.OK);

    }
}
