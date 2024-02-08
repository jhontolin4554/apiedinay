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
import com.apiedinay.sistemaediany.models.Costurero;
import com.apiedinay.sistemaediany.services.Costureroservices;
@RestController
@RequestMapping("/costureros")
public class CostureroController {

    @Autowired
    private Costureroservices costureroService;

    @GetMapping("/")
    public ResponseEntity<List<Costurero>> getAllCostureros() {
        List<Costurero> costureros = costureroService.getAllCostureros();
        return new ResponseEntity<>(costureros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Costurero> getCostureroById(@PathVariable Long id) {
        Optional<Costurero> costurero = costureroService.getCostureroById(id);
        return costurero.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<Costurero> createCosturero(@RequestBody Costurero costurero) {
        Costurero createdCosturero = costureroService.createCosturero(costurero);
        return new ResponseEntity<>(createdCosturero, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Costurero> updateCosturero(@PathVariable Long id, @RequestBody Costurero costurero) {
        Costurero updatedCosturero = costureroService.updateCosturero(id, costurero);
        return updatedCosturero != null ? new ResponseEntity<>(updatedCosturero, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCosturero(@PathVariable Long id) {
        costureroService.deleteCosturero(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}