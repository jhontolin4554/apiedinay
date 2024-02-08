package com.apiedinay.sistemaediany.models;

import jakarta.persistence.*;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String direccion;

    @Column
    private String telefono;

    @Column
    private String tipo;

    // Constructor
    public Empleado() {
    }

    // Getters y setters
    public Long getId() {
        return id;}
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;}
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;}
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;}
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getTipo() {
        return tipo;}
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }}