package com.apiedinay.sistemaediany.models;
import jakarta.persistence.*;
@Entity
@Table(name="mensualizado")
public class Mensualizado {
    @Id
    private Long idEmpleado;
    @Column
    private int pagoMensualizado; 

      // Getters y setters

      public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getPagoMensualizado() {
        return pagoMensualizado;
    }

    public void setPagoMensualizado(int pagoMensualizado) {
        this.pagoMensualizado = pagoMensualizado;
    }
}
