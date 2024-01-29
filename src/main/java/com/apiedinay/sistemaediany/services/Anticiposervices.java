package com.apiedinay.sistemaediany.services;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiedinay.sistemaediany.models.Anticipo;

import com.apiedinay.sistemaediany.repositories.AnticipoRepository;

@Service
public class Anticiposervices {
    @Autowired
    AnticipoRepository anticipoRepository;

    public ArrayList<Anticipo> getAnticipos(){
    return (ArrayList<Anticipo>)anticipoRepository.findAll();
   }

   public Anticipo saveAnticipo(Anticipo anticipo) {
    try {
        return anticipoRepository.save(anticipo);
    } catch (Exception e) {
        // Manejo de la excepción, por ejemplo, registrar o lanzar una excepción personalizada
        throw new RuntimeException("Error al guardar el anticipo", e);
    }
    }

    public Optional <Anticipo> GetById( Long Id){
        return anticipoRepository.findById(Id);
    }

    public Anticipo updateById(Anticipo requestEAnticipo , Long id){
        Anticipo anticipo= anticipoRepository.findById(id).get();
        anticipo.setCantidad(requestEAnticipo.getCantidad());
        anticipo.setFecha(requestEAnticipo.getFecha());
        anticipo.setIdEmpleado(requestEAnticipo.getIdEmpleado());
        anticipoRepository.save(anticipo);
        return anticipo;
    }

    public Boolean deleteById(Long id){
        try{
            anticipoRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}
