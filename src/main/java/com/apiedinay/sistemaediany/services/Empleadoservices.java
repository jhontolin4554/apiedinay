package com.apiedinay.sistemaediany.services;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiedinay.sistemaediany.models.Empleado;
import com.apiedinay.sistemaediany.repositories.EmpleadoRepository;

@Service
public class Empleadoservices {
   @Autowired 
   EmpleadoRepository empleadoRepository;

   public ArrayList<Empleado> getEmpleados(){
    return (ArrayList<Empleado>)empleadoRepository.findAll();
   }
   public ArrayList<Empleado> getCostureros() {
    List<Empleado> costureros = empleadoRepository.findByTipo("COSTURERO");
    return new ArrayList<>(costureros);
}

   public Empleado saveEmpleado(Empleado empleado) {
    try {
        return empleadoRepository.save(empleado);
    } catch (Exception e) {
        // Manejo de la excepción, por ejemplo, registrar o lanzar una excepción personalizada
        throw new RuntimeException("Error al guardar el empleado", e);
    }
    }

    public Optional <Empleado> GetById( Long Id){
        return empleadoRepository.findById(Id);
    }

    public Empleado updateById(Empleado requestEmpleado , Long id){
        Empleado empleado= empleadoRepository.findById(id).get();
        empleado.setNombre(requestEmpleado.getNombre());
        empleado.setDireccion(requestEmpleado.getDireccion());
        empleado.setTelefono(requestEmpleado.getTelefono());
        empleado.setTipo(requestEmpleado.getTipo());
        empleadoRepository.save(empleado);
        return empleado;
    }

    public Boolean deleteById(Long id){
        try{
            empleadoRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}
