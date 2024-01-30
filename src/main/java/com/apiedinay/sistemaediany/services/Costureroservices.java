package com.apiedinay.sistemaediany.services;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiedinay.sistemaediany.models.Costurero;

import com.apiedinay.sistemaediany.repositories.CostureroRepository;

@Service
public class Costureroservices {
    @Autowired
    CostureroRepository costureroRepository;

    public ArrayList<Costurero> getCostureros(){
    return (ArrayList<Costurero>)costureroRepository.findAll();
   }

   public Costurero saveCosturero(Costurero costurero) {
    
        return costureroRepository.save(costurero);
  
    }

    public Optional <Costurero> GetById( Long Id){
        return costureroRepository.findById(Id);
    }

    public Costurero updateById(Costurero requestCosturero , Long id){
        Costurero costurero= costureroRepository.findById(id).get();
        costurero.setIdEmpleado(requestCosturero.getIdEmpleado());
        costurero.setPagoFino(requestCosturero.getPagoFino());
        costurero.setPagoJuvenil(requestCosturero.getPagoJuvenil());
        costurero.setPagoNormal(requestCosturero.getPagoNormal());
        costureroRepository.save(costurero);
        return costurero;
    }

    public Boolean deleteById(Long id){
        try{
            costureroRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}
