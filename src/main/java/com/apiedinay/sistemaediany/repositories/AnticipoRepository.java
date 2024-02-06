package com.apiedinay.sistemaediany.repositories;
import org.springframework.stereotype.Repository;

import com.apiedinay.sistemaediany.models.Anticipo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface AnticipoRepository extends JpaRepository<Anticipo,Long> {
    ArrayList<Anticipo> findByEmpleadoId(Long idEmpleado);
}
