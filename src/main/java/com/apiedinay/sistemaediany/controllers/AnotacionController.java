package com.apiedinay.sistemaediany.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiedinay.sistemaediany.models.Anotacion;
import com.apiedinay.sistemaediany.services.Anotacionservices;

@RestController
@RequestMapping("/anotacion")
public class AnotacionController {
    @Autowired
    private Anotacionservices anotacionservices;

    @GetMapping
    public ArrayList<Anotacion> getanotAnotacions(){
        return this.anotacionservices.getAnotaciones();
    }

    @PostMapping
    public ResponseEntity<Anotacion> saveAnotacion(@RequestBody Anotacion anotacion) {
        Anotacion savedEmpleado= this.anotacionservices.saveAnotacion(anotacion);
        return new ResponseEntity<>(savedEmpleado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Anotacion>> getAnotacionbyid(@PathVariable("id") Long id) {
        Optional<Anotacion> anotacion = this.anotacionservices.GetById(id);
        return ResponseEntity.ok(anotacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Anotacion> updateanotacionById(@RequestBody Anotacion anotacion, @PathVariable("id") long id) {
        Anotacion updatedAnotacion= this.anotacionservices.updateAnotacion(anotacion, id);
        return new ResponseEntity<>(updatedAnotacion, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        boolean ok = this.anotacionservices.deleteById(id);
        if (ok) {
            return new ResponseEntity<>("Se borró exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error al borrar", HttpStatus.NOT_FOUND);
        }
    }
}
