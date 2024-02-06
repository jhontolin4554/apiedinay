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

import com.apiedinay.sistemaediany.models.Anticipo;

import com.apiedinay.sistemaediany.services.Anticiposervices;

@RestController
@RequestMapping("/anticipo")
    public class AnticipoController {
    @Autowired
    Anticiposervices anticiposervices;
    @GetMapping
    public ArrayList<Anticipo> getanAnticipos(){
        return this.anticiposervices.getAnticipos();
    }

    @PostMapping
    public Anticipo saveAnticipos(@RequestBody Anticipo anticipo) {
        Anticipo savedAnticipo= this.anticiposervices.saveAnticipo(anticipo);
        return this.anticiposervices.saveAnticipo(savedAnticipo);

    }

    @GetMapping("/{id}")
    public Optional<Anticipo> getAnticipobyid(@PathVariable("id") Long id) {
        Optional<Anticipo> anticipo = this.anticiposervices.GetById(id);
        return this.anticiposervices.GetById(id);
    }

    @PutMapping("/{id}")
    public Anticipo updateanticipoById(@RequestBody Anticipo anticipo, @PathVariable("id") long id) {
        Anticipo updatedAnticipo= this.anticiposervices.updateById(anticipo, id);
        return this.anticiposervices.updateById(anticipo, id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.anticiposervices.deleteById(id);
        if (ok) {
            return "Se borró exitosamente";
        } else {
            return "Error al borrar";
        } 
        }
    }
