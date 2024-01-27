package com.apiedinay.sistemaediany.repositories;
import org.springframework.stereotype.Repository;

import com.apiedinay.sistemaediany.models.Mensualizado;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface MensualizadoRepository extends JpaRepository<Mensualizado,Long>{
    
}
