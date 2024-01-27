package com.apiedinay.sistemaediany.models;
import jakarta.persistence.*;
@Entity
@Table(name="costurero")
public class Costurero {
    @Id
    private Long idEmpleado; 
    @Column
    private int pagoFino;
    @Column
    private int pagoNormal;
    @Column
    private int pagoJuvenil;

      // Getters y setters

      public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getPagoFino() {
        return pagoFino;
    }
     public int getPagoJuvenil() {
        return pagoJuvenil;
    }
     
    public void setPagoJuvenil(int pagoJuvenil) {
        this.pagoJuvenil = pagoJuvenil;
    }

    public void setPagoFino(int pagoFino) {
        this.pagoFino = pagoFino;
    }

    public int getPagoNormal() {
        return pagoNormal;
    }

    public void setPagoNormal(int pagoNormal) {
        this.pagoNormal = pagoNormal;
    }
    
}
