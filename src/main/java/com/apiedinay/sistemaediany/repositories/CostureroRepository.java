package com.apiedinay.sistemaediany.repositories;
import org.springframework.stereotype.Repository;

import com.apiedinay.sistemaediany.models.Costurero;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface CostureroRepository extends JpaRepository<Costurero,Long>{
    
}
