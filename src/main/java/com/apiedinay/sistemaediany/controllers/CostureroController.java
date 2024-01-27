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

import com.apiedinay.sistemaediany.models.Costurero;
import com.apiedinay.sistemaediany.services.Costureroservices;

@RestController
@RequestMapping("/costurero")
public class CostureroController {
    @Autowired
    Costureroservices costureroservices;
     @GetMapping
    public ArrayList<Costurero> getcostureros(){
        return this.costureroservices.getCostureros();
    }

    @PostMapping
    public ResponseEntity<Costurero> saveCosturero(@RequestBody Costurero costurero) {
        Costurero savedCosturero= this.costureroservices.saveCosturero(costurero);
        return new ResponseEntity<>(savedCosturero, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Costurero>> getCosturerobyid(@PathVariable("id") Long id) {
        Optional<Costurero> costurero = this.costureroservices.GetById(id);
        return ResponseEntity.ok(costurero);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Costurero> updatecostureroById(@RequestBody Costurero costurero, @PathVariable("id") long id) {
        Costurero updatecosturero= this.costureroservices.updateById(costurero, id);
        return new ResponseEntity<>(updatecosturero, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        boolean ok = this.costureroservices.deleteById(id);
        if (ok) {
            return new ResponseEntity<>("Se borró exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error al borrar", HttpStatus.NOT_FOUND);
        } 
        }
}
