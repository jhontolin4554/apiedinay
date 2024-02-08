package com.apiedinay.sistemaediany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiedinay.sistemaediany.models.Anticipo;

import com.apiedinay.sistemaediany.repositories.AnticipoRepository;

@Service
public class Anticiposervices {
    @Autowired
    private AnticipoRepository anticipoRepository;

    public List<Anticipo> getAllAnticipos() {
        return anticipoRepository.findAll();
    }

    public Optional<Anticipo> getAnticipoById(Long id) {
        return anticipoRepository.findById(id);
    }

    public List<Anticipo> getAnticiposByEmpleadoId(Long idEmpleado) {
        return anticipoRepository.findByIdEmpleado(idEmpleado);
    }

    public Anticipo createAnticipo(Anticipo anticipo) {
        return anticipoRepository.save(anticipo);
    }

    public Anticipo updateAnticipo(Long id, Anticipo anticipo) {
        if (anticipoRepository.existsById(id)) {
            anticipo.setId(id);
            return anticipoRepository.save(anticipo);
        }
        return null;
    }

    public void deleteAnticipo(Long id) {
        anticipoRepository.deleteById(id);
    }
}