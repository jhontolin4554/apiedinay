package com.apiedinay.sistemaediany.controllers;

import java.util.List;
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

import com.apiedinay.sistemaediany.models.Anote;
import com.apiedinay.sistemaediany.services.Anotacionservices;
@RestController
@RequestMapping("/anotes")
public class AnoteController {

    @Autowired
    private Anotacionservices anoteService;

    @GetMapping("/")
    public ResponseEntity<List<Anote>> getAllAnotaciones() {
        List<Anote> anotes = anoteService.getAllAnotaciones();
        return new ResponseEntity<>(anotes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anote> getAnotacionById(@PathVariable Long id) {
        Optional<Anote> anote = anoteService.getAnotacionById(id);
        return anote.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/empleado/{idEmpleado}")
    public ResponseEntity<List<Anote>> getAnotacionesByEmpleadoId(@PathVariable Long idEmpleado) {
        List<Anote> anotes = anoteService.getAnotacionesByEmpleadoId(idEmpleado);
        return new ResponseEntity<>(anotes, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Anote> createAnotacion(@RequestBody Anote anote) {
        Anote createdAnotacion = anoteService.createAnotacion(anote);
        return new ResponseEntity<>(createdAnotacion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Anote> updateAnotacion(@PathVariable Long id, @RequestBody Anote anote) {
        Anote updatedAnotacion = anoteService.updateAnotacion(id, anote);
        return updatedAnotacion != null ? new ResponseEntity<>(updatedAnotacion, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnotacion(@PathVariable Long id) {
        anoteService.deleteAnotacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}