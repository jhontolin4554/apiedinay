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

import com.apiedinay.sistemaediany.models.Anticipo;

import com.apiedinay.sistemaediany.services.Anticiposervices;


@RestController
@RequestMapping("/anticipos")
public class AnticipoController {

    @Autowired
    private Anticiposervices anticipoService;

    @GetMapping("/")
    public ResponseEntity<List<Anticipo>> getAllAnticipos() {
        List<Anticipo> anticipos = anticipoService.getAllAnticipos();
        return new ResponseEntity<>(anticipos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anticipo> getAnticipoById(@PathVariable Long id) {
        Optional<Anticipo> anticipo = anticipoService.getAnticipoById(id);
        return anticipo.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/empleado/{idEmpleado}")
    public ResponseEntity<List<Anticipo>> getAnticiposByEmpleadoId(@PathVariable Long idEmpleado) {
        List<Anticipo> anticipos = anticipoService.getAnticiposByEmpleadoId(idEmpleado);
        return new ResponseEntity<>(anticipos, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Anticipo> createAnticipo(@RequestBody Anticipo anticipo) {
        Anticipo createdAnticipo = anticipoService.createAnticipo(anticipo);
        return new ResponseEntity<>(createdAnticipo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Anticipo> updateAnticipo(@PathVariable Long id, @RequestBody Anticipo anticipo) {
        Anticipo updatedAnticipo = anticipoService.updateAnticipo(id, anticipo);
        return updatedAnticipo != null ? new ResponseEntity<>(updatedAnticipo, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnticipo(@PathVariable Long id) {
        anticipoService.deleteAnticipo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}