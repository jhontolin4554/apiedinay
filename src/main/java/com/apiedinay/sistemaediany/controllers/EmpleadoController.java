package com.apiedinay.sistemaediany.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.apiedinay.sistemaediany.models.Empleado;
import com.apiedinay.sistemaediany.services.Empleadoservices;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired 
    private Empleadoservices empleadoservices;

    @GetMapping
    public ArrayList<Empleado> getEmpleados() {
        return this.empleadoservices.getEmpleados();
    }

    @PostMapping
    public ResponseEntity<Empleado> saveEmpleado(@RequestBody Empleado empleado) {
        Empleado savedEmpleado = this.empleadoservices.saveEmpleado(empleado);
        return new ResponseEntity<>(savedEmpleado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Empleado>> getEmpleadobyid(@PathVariable("id") Long id) {
        Optional<Empleado> empleado = this.empleadoservices.GetById(id);
        return ResponseEntity.ok(empleado);
    }
    @GetMapping("/costurero")
    public ArrayList<Empleado>  getCosturero() {
        
        return this.getCosturero();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> updateempleadoById(@RequestBody Empleado empleado, @PathVariable("id") long id) {
        Empleado updatedEmpleado = this.empleadoservices.updateById(empleado, id);
        return new ResponseEntity<>(updatedEmpleado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        boolean ok = this.empleadoservices.deleteById(id);
        if (ok) {
            return new ResponseEntity<>("Se borró exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error al borrar", HttpStatus.NOT_FOUND);
        }
    }
}
