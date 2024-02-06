package com.apiedinay.sistemaediany.repositories;
import org.springframework.stereotype.Repository;

import com.apiedinay.sistemaediany.models.Anticipo;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AnticipoRepository extends JpaRepository<Anticipo,Long> {
    
}
