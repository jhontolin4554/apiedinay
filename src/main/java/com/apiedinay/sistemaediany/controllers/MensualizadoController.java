package com.apiedinay.sistemaediany.controllers;

import java.util.ArrayList;
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
import com.apiedinay.sistemaediany.models.Mensualizado;
import com.apiedinay.sistemaediany.services.Mensualizadoservices;
@RestController
@RequestMapping("/mensualizados")
public class MensualizadoController {

    @Autowired
    private Mensualizadoservices mensualizadoService;

    @GetMapping("/")
    public ResponseEntity<List<Mensualizado>> getAllMensualizados() {
        List<Mensualizado> mensualizados = mensualizadoService.getAllMensualizados();
        return new ResponseEntity<>(mensualizados, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mensualizado> getMensualizadoById(@PathVariable Long id) {
        Optional<Mensualizado> mensualizado = mensualizadoService.getMensualizadoById(id);
        return mensualizado.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<Mensualizado> createMensualizado(@RequestBody Mensualizado mensualizado) {
        Mensualizado createdMensualizado = mensualizadoService.createMensualizado(mensualizado);
        return new ResponseEntity<>(createdMensualizado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mensualizado> updateMensualizado(@PathVariable Long id, @RequestBody Mensualizado mensualizado) {
        Mensualizado updatedMensualizado = mensualizadoService.updateMensualizado(id, mensualizado);
        return updatedMensualizado != null ? new ResponseEntity<>(updatedMensualizado, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMensualizado(@PathVariable Long id) {
        mensualizadoService.deleteMensualizado(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}