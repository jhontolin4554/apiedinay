package com.apiedinay.sistemaediany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiedinay.sistemaediany.models.Mensualizado;
import com.apiedinay.sistemaediany.repositories.MensualizadoRepository;
@Service
public class Mensualizadoservices {
    @Autowired
    private MensualizadoRepository mensualizadoRepository;

    public List<Mensualizado> getAllMensualizados() {
        return mensualizadoRepository.findAll();
    }

    public Optional<Mensualizado> getMensualizadoById(Long id) {
        return mensualizadoRepository.findById(id);
    }

    public Mensualizado createMensualizado(Mensualizado mensualizado) {
        return mensualizadoRepository.save(mensualizado);
    }

    public Mensualizado updateMensualizado(Long id, Mensualizado mensualizado) {
        if (mensualizadoRepository.existsById(id)) {
            mensualizado.setIdEmpleado(id);
            return mensualizadoRepository.save(mensualizado);
        }
        return null;
    }

    public void deleteMensualizado(Long id) {
        mensualizadoRepository.deleteById(id);
    }

}
