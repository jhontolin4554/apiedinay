package com.apiedinay.sistemaediany.services;
import java.util.ArrayList;
import java.util.List;
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
     public ArrayList<Anticipo> getAnticiposPorEmpleado(Long idEmpleado) {
        return new ArrayList<>(anticipoRepository.findByEmpleadoId(idEmpleado));
    }
   public Anticipo saveAnticipo(Anticipo anticipo) {
   
        return anticipoRepository.save(anticipo);
   
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
