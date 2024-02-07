package com.apiedinay.sistemaediany.models;
import java.util.Date;

import jakarta.persistence.*;
@Entity
@Table(name="anticipo")
public class Anticipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Date fecha;
    @Column
    private int cantidad;
    @Column
    private Long idEmpleado;
      public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Long getIdEmpleado() {
        return idEmpleado;
    }
    
    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

}
