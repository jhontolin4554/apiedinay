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
import com.apiedinay.sistemaediany.models.Mensualizado;
import com.apiedinay.sistemaediany.services.Mensualizadoservices;

@RestController
@RequestMapping("/mensualizado")
public class MensualizadoController {
    @Autowired
    Mensualizadoservices mensualizadoservices;

     @GetMapping
    public ArrayList<Mensualizado> getMensualizados(){
        return this.mensualizadoservices.getMensualizados();
    }

    @PostMapping
    public ResponseEntity<Mensualizado> saveMensualizado(@RequestBody Mensualizado mensualizado) {
        Mensualizado savedMensualizado= this.mensualizadoservices.saveMensualizado(mensualizado);
        return new ResponseEntity<>(savedMensualizado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Mensualizado>> getMensualizadobyid(@PathVariable("id") Long id) {
        Optional<Mensualizado> mensualizado = this.mensualizadoservices.GetById(id);
        return ResponseEntity.ok(mensualizado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mensualizado> updatemensualizadoById(@RequestBody Mensualizado mensualizado, @PathVariable("id") long id) {
        Mensualizado updateMensualizado= this.mensualizadoservices.updateById(mensualizado, id);
        return new ResponseEntity<>(updateMensualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        boolean ok = this.mensualizadoservices.deleteById(id);
        if (ok) {
            return new ResponseEntity<>("Se borró exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error al borrar", HttpStatus.NOT_FOUND);
        } 
        }
}
