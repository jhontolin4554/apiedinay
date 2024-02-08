package com.apiedinay.sistemaediany.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiedinay.sistemaediany.models.Anote;
import com.apiedinay.sistemaediany.repositories.AnotacionRepository;

@Service
public class Anotacionservices {
    @Autowired
    private AnotacionRepository anoteRepository;

    public List<Anote> getAllAnotaciones() {
        return anoteRepository.findAll();
    }

    public Optional<Anote> getAnotacionById(Long id) {
        return anoteRepository.findById(id);
    }

    public List<Anote> getAnotacionesByEmpleadoId(Long idEmpleado) {
        return anoteRepository.findByIdEmpleado(idEmpleado);
    }

    public Anote createAnotacion(Anote anote) {
        return anoteRepository.save(anote);
    }

    public Anote updateAnotacion(Long id, Anote anote) {
        if (anoteRepository.existsById(id)) {
            anote.setId(id);
            return anoteRepository.save(anote);
        }
        return null;
    }

    public void deleteAnotacion(Long id) {
        anoteRepository.deleteById(id);
    }
}
