package com.apiedinay.sistemaediany.models;
import jakarta.persistence.*;

@Entity
@Table(name = "costurero")
public class Costurero {

    @Id
    @Column(name = "id_empleado")
    private Long idEmpleado;

    @Column(name = "pago_fino")
    private Integer pagoFino;

    @Column(name = "pago_normal")
    private Integer pagoNormal;

    @Column(name = "pago_juvenil")
    private Integer pagoJuvenil;

    // Constructor
    public Costurero() {
    }

    // Getters y setters
    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getPagoFino() {
        return pagoFino;
    }
    public void setPagoFino(Integer pagoFino) {
        this.pagoFino = pagoFino;
    }

    public Integer getPagoNormal() {
        return pagoNormal;
    }

    public void setPagoNormal(Integer pagoNormal) {
        this.pagoNormal = pagoNormal;
    }

    public Integer getPagoJuvenil() {
        return pagoJuvenil;
    }

    public void setPagoJuvenil(Integer pagoJuvenil) {
        this.pagoJuvenil = pagoJuvenil;
    }
}