package com.apiedinay.sistemaediany.repositories;
import org.springframework.stereotype.Repository;

import com.apiedinay.sistemaediany.models.Anticipo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AnticipoRepository extends JpaRepository<Anticipo,Long> {
    List<Anticipo> findByEmpleadoId(Long idEmpleado);
}
