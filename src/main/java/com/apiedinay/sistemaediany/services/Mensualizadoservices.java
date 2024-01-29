package com.apiedinay.sistemaediany.services;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiedinay.sistemaediany.models.Mensualizado;
import com.apiedinay.sistemaediany.repositories.MensualizadoRepository;
@Service
public class Mensualizadoservices {
    @Autowired
    MensualizadoRepository mensualizadoRepository;

    public ArrayList<Mensualizado> getMensualizados(){
        return (ArrayList<Mensualizado>)mensualizadoRepository.findAll();
       }
    
       public Mensualizado saveMensualizado(Mensualizado mensualizado) {
        try {
            return mensualizadoRepository.save(mensualizado);
        } catch (Exception e) {
            // Manejo de la excepción, por ejemplo, registrar o lanzar una excepción personalizada
            throw new RuntimeException("Error al guardar el mensualizado", e);
        }
        }
    
        public Optional <Mensualizado> GetById( Long Id){
            return mensualizadoRepository.findById(Id);
        }
    
        public Mensualizado updateById(Mensualizado requestmMensualizado, Long id){
            Mensualizado mensualizado= mensualizadoRepository.findById(id).get();
            mensualizado.setPagoMensualizado(requestmMensualizado.getPagoMensualizado());
            mensualizadoRepository.save(mensualizado);
            return mensualizado;
        }
    
        public Boolean deleteById(Long id){
            try{
                mensualizadoRepository.deleteById(id);
                return true;
            }
            catch (Exception e){
                return false;
            }
        }
    
}
