package com.apiedinay.sistemaediany.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiedinay.sistemaediany.models.Costurero;

import com.apiedinay.sistemaediany.repositories.CostureroRepository;

@Service
public class Costureroservices {
    @Autowired
    private CostureroRepository costureroRepository;

    public List<Costurero> getAllCostureros() {
        return costureroRepository.findAll();
    }

    public Optional<Costurero> getCostureroById(Long id) {
        return costureroRepository.findById(id);
    }

    public Costurero createCosturero(Costurero costurero) {
        return costureroRepository.save(costurero);
    }

    public Costurero updateCosturero(Long id, Costurero costurero) {
        if (costureroRepository.existsById(id)) {
            costurero.setIdEmpleado(id);
            return costureroRepository.save(costurero);
        }
        return null;
    }

    public void deleteCosturero(Long id) {
        costureroRepository.deleteById(id);
    }
}