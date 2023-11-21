package com.estudiantes.controller;

import com.estudiantes.dto.OpcionDto;
import com.estudiantes.service.OpcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/opcion")
public class OpcionController {

    @Autowired
    private OpcionService opcionService;

    @GetMapping("/all")
    public ResponseEntity<?> listarOpciones(){
        return new ResponseEntity<>(opcionService.obtenerOpciones(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerOpcion(@PathVariable("id") int id){
        OpcionDto opcion = opcionService.obtenerOpcion(id);
        if (opcion == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(opcion, HttpStatus.OK);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarOpcion(@RequestBody OpcionDto opcionDto) throws Exception {

        OpcionDto opcionSaved = opcionService.guardarOpcion(opcionDto);
        return new ResponseEntity<>(opcionSaved, HttpStatus.CREATED);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarEjercicio(@PathVariable("id") int id, @RequestBody OpcionDto opcion) throws Exception {
        OpcionDto opcionUpdated =  opcionService.editarOpcion(id, opcion);
        if (opcionUpdated == null){
            return new ResponseEntity<>("La opcion que desea editar no existe", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(opcionUpdated, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarEjercicio(@PathVariable("id") int id) throws Exception {
        boolean opcionDeleted =  opcionService.eliminarOpcion(id);
        if (opcionDeleted){
            return new ResponseEntity<>("Opcion eliminada satisfactoriamente", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("La opcion no existe", HttpStatus.NOT_FOUND);
    }
}
