package com.apiedinay.sistemaediany.models;
import jakarta.persistence.*;

@Entity
@Table(name = "mensualizado")
public class Mensualizado {

    @Id
    @Column(name = "id_empleado")
    private Long idEmpleado;

    @Column(name = "pago_mensualizado")
    private Integer pagoMensualizado;

    // Constructor
    public Mensualizado() {
    }

    // Getters y setters
    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getPagoMensualizado() {
        return pagoMensualizado;
    }

    public void setPagoMensualizado(Integer pagoMensualizado) {
        this.pagoMensualizado = pagoMensualizado;
    }}