package com.apiedinay.sistemaediany.services;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiedinay.sistemaediany.models.Anotacion;
import com.apiedinay.sistemaediany.repositories.AnotacionRepository;

@Service
public class Anotacionservices {
    @Autowired
    AnotacionRepository anotacionRepository;
    public ArrayList<Anotacion> getAnotaciones(){
        return (ArrayList<Anotacion>) anotacionRepository.findAll();
    }

    public Anotacion saveAnotacion(Anotacion anotacion){
        try{
            return anotacionRepository.save(anotacion);
        }
        catch(Exception e){
            throw new RuntimeException("Error al crear anote");
        }
    }

    public Optional <Anotacion> GetById(Long Id){
        return anotacionRepository.findById(Id);
    }

    public Anotacion updateAnotacion(Anotacion requeAnotacion, Long id){
        Anotacion anotacion = anotacionRepository.findById(id).get();
        anotacion.setCantidad(requeAnotacion.getCantidad());
        anotacion.setColor(requeAnotacion.getColor());
        anotacion.setFechaEntrega(requeAnotacion.getFechaEntrega());
        anotacion.setIdEmpleado(requeAnotacion.getIdEmpleado());
        anotacionRepository.save(anotacion);
        return anotacion;
    }
    public Boolean deleteById(Long id){
        try{
            anotacionRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }
}
